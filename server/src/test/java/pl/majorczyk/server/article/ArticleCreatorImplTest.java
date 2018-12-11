package pl.majorczyk.server.article;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.majorczyk.server.user.UserEntity;
import pl.majorczyk.server.user.UserRepository;
import pl.majorczyk.server.utils.UserUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleCreatorImplTest {

    private static final String DEFAULT_IMG_URL = "https://freephotos.cc/storage/preview/path/hM8bEk9yc4tfGoTp5aheU2u01B3Bn9FJyI8ZRtgE.jpeg";

    private ArticleCreator articleCreator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Before
    public void setUp() {
        articleCreator = new ArticleCreatorImpl(userRepository, articleRepository);
        userRepository.save(UserUtils.getDefaultUser());
    }

    @Test
    public void shouldCreateArticle() {
        //given
        UserEntity user = UserUtils.getDefaultUser();
        ArticleData data = new ArticleData("title", "content", "http://test.com", user.getUsername());

        //when
        ArticleEntity article = articleCreator.createArticle(data);

        //then
        assertNotNull(article);
        //TODO
        assertNotNull(article.getId());
        assertEquals("title", article.getTitle());
        assertEquals("content", article.getContent());
        assertEquals("http://test.com", article.getImgUrl());
        assertNotNull(article.getCreationTime());
    }

    @Test
    public void ifNullImageUrl_shouldSetDefaultImageUrl() {
        //given
        ArticleData data = new ArticleData("title", "content", null, "user");

        //when
        ArticleEntity article = articleCreator.createArticle(data);

        //then
        assertNotNull(article.getImgUrl());
        assertEquals(DEFAULT_IMG_URL, article.getImgUrl());
    }

    @Test
    public void ifEmptyImageUrl_shouldSetDefaultImageUrl() {
        //given
        ArticleData data = new ArticleData("title", "content", "", "user");

        //when
        ArticleEntity article = articleCreator.createArticle(data);

        //then
        assertNotNull(article.getImgUrl());
        assertEquals(DEFAULT_IMG_URL, article.getImgUrl());
    }
}