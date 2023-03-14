package lu.atozdigital.api.models;

import jakarta.persistence.*;
import lu.atozdigital.api.models.base.BaseModel;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "online_order")
public class OnlineOrder extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Integer id;

    @Column(name = "reference", unique = true, updatable = false, nullable = false)
    private String reference;

    @ManyToMany
    @JoinTable(
            name = "online_order_article_association",
            joinColumns = @JoinColumn(name = "online_order_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private Set<Article> articles = new HashSet<>();

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

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
