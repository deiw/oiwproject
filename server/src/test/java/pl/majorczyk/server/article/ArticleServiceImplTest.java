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
import pl.majorczyk.server.user.UserRepository;
import pl.majorczyk.server.utils.UserUtils;

import java.util.Objects;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleServiceImplTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    private ArticleService articleService;

    @Before
    public void setUp() {
        ArticleCreator articleCreator = new ArticleCreatorImpl(userRepository, articleRepository);
        ArticlePreviewMapper articlePreviewMapper = new ArticlePreviewMapperImpl();
        ArticleMapper articleMapper = new ArticleMapperImpl();
        this.articleService = new ArticleServiceImpl(articleRepository, articleCreator, articlePreviewMapper, articleMapper);
        userRepository.save(UserUtils.getDefaultUser());
    }

    @Test
    public void shouldSaveArticle() {
        //given
        ArticleData articleData = new ArticleData("title", "content", "http://test.com", "user");

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
        ArticleData articleData = new ArticleData("title", "content", "http://test.com", "user");
        articleService.saveArticle(articleData);

        //when
        Article result = articleService.findArticleByTitle("title");

        //then
        assertNotNull(result);
        assertEquals(articleData.getTitle(), result.getTitle());
        assertEquals(articleData.getContent(), result.getContent());
    }

    @Test(expected = ArticleNotFoundException.class)
    public void ifArticleNotFound_shouldThrowException() {
        //given
        ArticleData articleData = new ArticleData("title", "content", "http://test.com", "user");
        articleService.saveArticle(articleData);

        //when
        articleService.findArticleByTitle("testTitle");

        //then
    }

    @Test
    public void shouldReturnArticlesPreviewWithDefaultPageable() {
        //given
        for (int i = 0; i < 15; i++) {
            articleService.saveArticle(new ArticleData("title" + i, "content" + i, "http://test.com", "user"));
        }

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "creationTime");

        //when
        Page<ArticlePreview> articles = articleService.getArticlePage(pageRequest);

        //then
        assertTrue(articles.hasContent());
        assertEquals(pageRequest.getPageSize(), articles.getContent().size());
        assertTrue(articles.getSort().isSorted());
        assertTrue(Objects.requireNonNull(articles.getSort().getOrderFor("creationTime")).isDescending());
    }
}