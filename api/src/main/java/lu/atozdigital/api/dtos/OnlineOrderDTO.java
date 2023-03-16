package lu.atozdigital.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lu.atozdigital.api.dtos.base.BaseDTO;

import java.util.List;

public class OnlineOrderDTO extends BaseDTO {

    private Integer id;

    private String reference;

    @JsonProperty("article_ids")
    private List<Integer> articleIds;

    private List<ArticleDTO> articles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Integer> getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(List<Integer> articleIds) {
        this.articleIds = articleIds;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }
}
