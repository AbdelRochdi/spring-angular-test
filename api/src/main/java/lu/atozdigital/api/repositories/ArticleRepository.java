package lu.atozdigital.api.repositories;

import lu.atozdigital.api.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findByUuid(UUID uuid);
}
