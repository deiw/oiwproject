package pl.majorczyk.server.article;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticleCreatorImplTest {

    private ArticleCreator articleCreator;

    @Before
    public void setUp() {
        articleCreator = new ArticleCreatorImpl();
    }

    @Test
    public void shouldCreateArticle() {
        //given
        ArticleData data = new ArticleData("title", "content");

        //when
        Article article = articleCreator.createArticle(data);

        //then
        assertNotNull(article);
        assertEquals("title", article.getTitle());
        assertEquals("content", article.getContent());
        assertNotNull(article.getCreationTime());
    }
}