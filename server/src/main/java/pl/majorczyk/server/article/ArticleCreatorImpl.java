package pl.majorczyk.server.article;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
class ArticleCreatorImpl implements ArticleCreator {

    @Override
    public Article createArticle(ArticleData articleData) {
        return Article.builder()
                .title(articleData.getTitle())
                .content(articleData.getContent())
                .creationTime(OffsetDateTime.now())
                .build();
    }
}
