package lu.atozdigital.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.services.ArticleService;
import lu.atozdigital.api.shared.exceptions.ServerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class.getName());

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO, MultipartFile image) throws ServerException {
        Article article = modelMapper.map(articleDTO, Article.class);
        try {
            if (image != null){
                article.setImage(image.getBytes());
            }
        }catch (IOException e){
            LOGGER.log(Level.SEVERE, "failed to convert image to bytes", e);
            throw new ServerException("An error occured");
        }
        article.setId(null);

        return modelMapper.map(articleRepository.save(article), ArticleDTO.class);
    }

    @Override
    public ArticleDTO getArticleById(Integer id){
        Article article = articleRepository.findById(id).orElseThrow(() -> {
            LOGGER.log(Level.SEVERE, "no article found with uuid [{0}]", id);
            return new EntityNotFoundException("Failed to fetch article");
        });
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public List<ArticleDTO> getAllArticlesDTOs(){
        return articleRepository.findAll()
                .stream()
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .toList();
    }

    @Override
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }
}
