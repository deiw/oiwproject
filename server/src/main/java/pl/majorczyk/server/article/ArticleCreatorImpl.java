package pl.majorczyk.server.article;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.function.Predicate;

@Service
class ArticleCreatorImpl implements ArticleCreator {

    private static final String DEFAULT_IMG_URL = "https://cdn.pixabay.com/photo/2018/10/30/09/12/coffee-3783137_1280.jpg";

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
