package pl.majorczyk.server.article;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findByTitle(String title);
}
