package pl.majorczyk.server.article;

public interface ArticleCreator {
    ArticleEntity createArticle(ArticleData articleData);
}
