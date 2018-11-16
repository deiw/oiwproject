package pl.majorczyk.server.article;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleCreator articleCreator;

    @Override
    public Article saveArticle(ArticleData articleData) {
        Article article = articleCreator.createArticle(articleData);
        return articleRepository.save(article);
    }

    @Override
    public Page<Article> getArticlePage(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article findArticleByTitle(String title) {
        return articleRepository.findByTitle(title)
                .orElseThrow(ArticleNotFoundException::new);
    }
}
