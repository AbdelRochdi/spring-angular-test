package lu.atozdigital.api.dtos;

import lu.atozdigital.api.dtos.base.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArticleDTO extends BaseDTO {

    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private Float price;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
