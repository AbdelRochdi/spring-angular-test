package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO){
        ArticleDTO article = articleService.createArticle(articleDTO);

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleByUuid(@PathVariable(name = "id") Integer id){
        ArticleDTO article = articleService.getArticleById(id);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles(){
        List<ArticleDTO> articles = articleService.getAllArticlesDTOs();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

}
