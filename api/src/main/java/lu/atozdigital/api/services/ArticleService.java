package lu.atozdigital.api.services;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.models.Article;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO);

    ArticleDTO getArticleById(Integer id);

    List<ArticleDTO> getAllArticlesDTOs();

    List<Article> getAllArticles();
}
