package lu.atozdigital.api.services;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.shared.exceptions.ServerException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO, MultipartFile image) throws ServerException;

    ArticleDTO getArticleById(Integer id);

    List<ArticleDTO> getAllArticlesDTOs();

    List<Article> getAllArticles();
}
