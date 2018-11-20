package pl.majorczyk.server.article;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleServiceImplTest {

    @Autowired
    private ArticleRepository articleRepository;
    private ArticleService articleService;

    @Before
    public void setUp() {
        ArticleCreator articleCreator = new ArticleCreatorImpl();
        this.articleService = new ArticleServiceImpl(articleRepository, articleCreator);
    }

    @Test
    public void shouldSaveArticle() {
        //given
        ArticleData articleData = new ArticleData("title", "content", "http://test.com");

        //when
        Article result = articleService.saveArticle(articleData);

        //then
        assertNotNull(result);
        assertEquals("title", result.getTitle());
        assertEquals("content", result.getContent());
    }

    @Test
    public void shouldGetArticleByTitle() {
        //given
        ArticleData articleData = new ArticleData("title", "content", "http://test.com");
        articleService.saveArticle(articleData);

        //when
        Article result = articleService.findArticleByTitle("title");

        //then
        assertNotNull(result);
        assertEquals(1L, result.getId().longValue());
        assertEquals(articleData.getTitle(), result.getTitle());
    }

    @Test(expected = ArticleNotFoundException.class)
    public void ifArticleNotFound_shouldThrowException() {
        //given
        ArticleData articleData = new ArticleData("title", "content", "http://test.com");
        articleService.saveArticle(articleData);

        //when
        articleService.findArticleByTitle("testTitle");

        //then
    }

    @Test
    public void shouldReturnArticlesWithDefaultPageable() {
        //given
        for (int i = 0; i < 15; i++) {
            articleService.saveArticle(new ArticleData("title" + i, "content" + i, "http://test.com"));
        }

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "creationTime");

        //when
        Page<Article> articles = articleService.getArticlePage(pageRequest);

        //then
        assertTrue(articles.hasContent());
        assertEquals(pageRequest.getPageSize(), articles.getContent().size());
        assertTrue(articles.getSort().isSorted());
        assertTrue(Objects.requireNonNull(articles.getSort().getOrderFor("creationTime")).isDescending());
    }
}