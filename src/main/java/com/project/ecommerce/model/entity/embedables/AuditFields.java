package com.project.ecommerce.model.entity.embedables;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Embeddable
@Getter @Setter
public class AuditFields {

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = Timestamp.from(Instant.now());
    }


}
