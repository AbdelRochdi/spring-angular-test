package lu.atozdigital.api.services.impl;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void createArticle(ArticleDTO articleDTO){



    }
}
