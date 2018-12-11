package pl.majorczyk.server.article;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.majorczyk.server.user.UserEntity;
import pl.majorczyk.server.user.UserNotFoundException;
import pl.majorczyk.server.user.UserRepository;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
class ArticleCreatorImpl implements ArticleCreator {

    private static final String DEFAULT_IMG_URL = "https://freephotos.cc/storage/preview/path/hM8bEk9yc4tfGoTp5aheU2u01B3Bn9FJyI8ZRtgE.jpeg";
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Override
    public ArticleEntity createArticle(ArticleData articleData) {

        UserEntity user = userRepository.findByUsername(articleData.getCreator())
                .orElseThrow(UserNotFoundException::new);

        ArticleEntity article = ArticleEntity.builder()
                .title(articleData.getTitle())
                .content(articleData.getContent())
                .imgUrl(setImageUrl(articleData.getImgUrl()))
                .creationTime(OffsetDateTime.now())
                .creator(user)
                .build();

        return articleRepository.save(article);
    }

    private String setImageUrl(String imgUrl) {
        return Optional.ofNullable(imgUrl)
                .filter(s -> !s.equals(""))
                .orElse(DEFAULT_IMG_URL);
    }
}
