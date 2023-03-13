package lu.atozdigital.api.models.base;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public class BaseModel {

    private Date creationDate;

    private Date modificationDate;

    @PrePersist
    public final void prePersistActions() {
        Date date = new Date();
        setCreationDate(date);
        setModificationDate(date);
    }

    @PreUpdate
    public final void preUpdateActions() {
        setModificationDate(new Date());
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
