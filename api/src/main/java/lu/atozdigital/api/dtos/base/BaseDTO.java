package lu.atozdigital.api.dtos.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseDTO {

    @JsonProperty("creation_date")
    private Long creationDate;

    @JsonProperty("modification_date")
    private Long modificationDate;

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Long modificationDate) {
        this.modificationDate = modificationDate;
    }

}
