package lu.atozdigital.api.services;

import lu.atozdigital.api.dtos.ArticleDTO;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO);

    ArticleDTO getArticleByUuid(UUID uuid);

    List<ArticleDTO> getAllArticles();
}
