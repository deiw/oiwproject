package pl.majorczyk.server.article;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticleCreatorImplTest {

    private static final String DEFAULT_IMG_URL = "https://freephotos.cc/storage/preview/path/hM8bEk9yc4tfGoTp5aheU2u01B3Bn9FJyI8ZRtgE.jpeg";

    private ArticleCreator articleCreator;

    @Before
    public void setUp() {
        articleCreator = new ArticleCreatorImpl();
    }

    @Test
    public void shouldCreateArticle() {
        //given
        ArticleData data = new ArticleData("title", "content", "http://test.com");

        //when
        Article article = articleCreator.createArticle(data);

        //then
        assertNotNull(article);
        assertEquals("title", article.getTitle());
        assertEquals("content", article.getContent());
        assertEquals("http://test.com", article.getImgUrl());
        assertNotNull(article.getCreationTime());
    }

    @Test
    public void ifNullImageUrl_shouldSetDefaultImageUrl() {
        //given
        ArticleData data = new ArticleData("title", "content", null);

        //when
        Article article = articleCreator.createArticle(data);

        //then
        assertNotNull(article.getImgUrl());
        assertEquals(DEFAULT_IMG_URL, article.getImgUrl());
    }

    @Test
    public void ifEmptyImageUrl_shouldSetDefaultImageUrl() {
        //given
        ArticleData data = new ArticleData("title", "content", "");

        //when
        Article article = articleCreator.createArticle(data);

        //then
        assertNotNull(article.getImgUrl());
        assertEquals(DEFAULT_IMG_URL, article.getImgUrl());
    }
}