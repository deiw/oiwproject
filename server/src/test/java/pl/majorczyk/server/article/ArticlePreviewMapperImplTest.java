package pl.majorczyk.server.article;


import org.junit.Before;
import org.junit.Test;
import pl.majorczyk.server.utils.UserUtils;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticlePreviewMapperImplTest {

    private ArticlePreviewMapper articlePreviewMapper;

    @Before
    public void setUp() {
        articlePreviewMapper = new ArticlePreviewMapperImpl();
    }

    @Test
    public void shouldMapArticleToDemoVersionWithoutContent() {
        //given
        ArticleEntity article = ArticleEntity.builder()
                .id(1L)
                .title("title")
                .content("content")
                .creationTime(OffsetDateTime.now())
                .imgUrl("http://url.com")
                .creator(UserUtils.getDefaultUser())
                .build();

        //when
        ArticlePreview result = articlePreviewMapper.mapToPreview(article);

        //then
        assertNotNull(result);
        assertEquals(result.getTitle(), article.getTitle());
        assertEquals(result.getCreationTime(), article.getCreationTime());
        assertEquals(result.getId(), article.getId());
        assertEquals(result.getImgUrl(), article.getImgUrl());
    }
}