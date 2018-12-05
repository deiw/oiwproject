package pl.majorczyk.server.article;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
class ArticleCreatorImpl implements ArticleCreator {

    private static final String DEFAULT_IMG_URL = "https://freephotos.cc/storage/preview/path/hM8bEk9yc4tfGoTp5aheU2u01B3Bn9FJyI8ZRtgE.jpeg";

    @Override
    public Article createArticle(ArticleData articleData) {
        return Article.builder()
                .title(articleData.getTitle())
                .content(articleData.getContent())
                .imgUrl(setImageUrl(articleData.getImgUrl()))
                .creationTime(OffsetDateTime.now())
                .build();
    }

    private String setImageUrl(String imgUrl) {
        return Optional.ofNullable(imgUrl)
                .filter(s -> !s.equals(""))
                .orElse(DEFAULT_IMG_URL);
    }
}
