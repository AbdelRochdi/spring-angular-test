package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dtos.ArticleDTO;
import lu.atozdigital.api.services.ArticleService;
import lu.atozdigital.api.shared.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ArticleDTO> createArticle(@RequestPart("payload") ArticleDTO articleDTO,
                                                    @RequestPart(value = "image", required = false) MultipartFile image) throws ServerException {
        ArticleDTO article = articleService.createArticle(articleDTO, image);

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
