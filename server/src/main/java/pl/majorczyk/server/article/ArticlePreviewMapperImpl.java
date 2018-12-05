package pl.majorczyk.server.article;

import org.springframework.stereotype.Service;

@Service
public class ArticlePreviewMapperImpl implements ArticlePreviewMapper {

    @Override
    public ArticlePreview mapToPreview(Article article) {
        return ArticlePreview.builder()
                .id(article.getId())
                .title(article.getTitle())
                .creationTime(article.getCreationTime())
                .imgUrl(article.getImgUrl())
                .build();
    }
}
