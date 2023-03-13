package lu.atozdigital.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class.getName());

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO){
        Article article = modelMapper.map(articleDTO, Article.class);
        article.setUuid(UUID.randomUUID());

        return modelMapper.map(articleRepository.save(article), ArticleDTO.class);
    }

    @Override
    public ArticleDTO getArticleByUuid(UUID uuid){
        Article article = articleRepository.findByUuid(uuid).orElseThrow(() -> {
            LOGGER.log(Level.SEVERE, "no article found with uuid [{0}]", uuid);
            return new EntityNotFoundException("Failed to fetch article");
        });
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public List<ArticleDTO> getAllArticles(){
        return articleRepository.findAll()
                .stream()
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .collect(Collectors.toList());
    }
}
