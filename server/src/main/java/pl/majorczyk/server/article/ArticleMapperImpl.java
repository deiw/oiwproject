package pl.majorczyk.server.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public Article map(ArticleEntity articleEntity) {
        return Article.builder()
                .title(articleEntity.getTitle())
                .content(articleEntity.getContent())
                .imgUrl(articleEntity.getImgUrl())
                .creationTime(articleEntity.getCreationTime())
                .creator(articleEntity.getCreator().getUsername())
                .build();
    }
}
