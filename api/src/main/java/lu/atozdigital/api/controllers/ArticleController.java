package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    private ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO){
        ArticleDTO article = articleService.createArticle(articleDTO);

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    private ResponseEntity<ArticleDTO> getArticleByUuid(@PathVariable(name = "uuid") String uuid){
        ArticleDTO article = articleService.getArticleByUuid(UUID.fromString(uuid));

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<ArticleDTO>> getAllArticles(){
        List<ArticleDTO> articles = articleService.getAllArticles();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

}
