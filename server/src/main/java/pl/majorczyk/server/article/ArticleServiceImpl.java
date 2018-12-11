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
    private final ArticlePreviewMapper articlePreviewMapper;
    private final ArticleMapper articleMapper;

    @Override
    public Article saveArticle(ArticleData articleData) {
        ArticleEntity article = articleCreator.createArticle(articleData);
        return articleMapper.map(article);
    }

    @Override
    public Page<ArticlePreview> getArticlePage(Pageable pageable) {
        return articleRepository.findAll(pageable)
                .map(articlePreviewMapper::mapToPreview);
    }

    @Override
    public Article findArticleByTitle(String title) {
        ArticleEntity article = articleRepository.findByTitle(title)
                .orElseThrow(ArticleNotFoundException::new);
        return articleMapper.map(article);
    }
}
