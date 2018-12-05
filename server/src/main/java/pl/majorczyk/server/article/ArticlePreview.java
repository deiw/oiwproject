package pl.majorczyk.server.article;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Builder
@Data
public class ArticlePreview {
    private Long id;
    private String title;
    private OffsetDateTime creationTime;
    private String imgUrl;
}
