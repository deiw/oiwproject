package pl.majorczyk.server.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {
    Article saveArticle(ArticleData articleData);

    Page<Article> getArticlePage(Pageable pageable);

    Article findArticleByTitle(String title);
}
