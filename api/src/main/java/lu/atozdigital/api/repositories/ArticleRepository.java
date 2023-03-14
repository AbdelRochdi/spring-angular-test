package lu.atozdigital.api.repositories;

import lu.atozdigital.api.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
