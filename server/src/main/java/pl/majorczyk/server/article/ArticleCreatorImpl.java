package pl.majorczyk.server.article;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
class ArticleCreatorImpl implements ArticleCreator {

    private static final String DEFAULT_IMG_URL = "https://cdn.pixabay.com/photo/2018/10/30/09/12/coffee-3783137_1280.jpg";

    @Override
    public Article createArticle(ArticleData articleData) {
        return Article.builder()
                .title(articleData.getTitle())
                .content(articleData.getContent())
                .imgUrl(checkImgUrl(articleData.getImgUrl()))
                .creationTime(OffsetDateTime.now())
                .build();
    }

    private String checkImgUrl(String imgUrl) {
        return Optional.ofNullable(imgUrl).orElse(DEFAULT_IMG_URL);
    }
}
