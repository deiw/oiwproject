package pl.majorczyk.server.article;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class Article {

    private String title;
    private String content;
    private OffsetDateTime creationTime;
    private String imgUrl;
    private String creator;
}
