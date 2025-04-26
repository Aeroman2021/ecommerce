package com.project.E_Commerce.model.entity.embedables;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Description {
    private String irDesc;
    private String enDesc;
}
