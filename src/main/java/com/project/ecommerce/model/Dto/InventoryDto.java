package com.project.ecommerce.model.Dto;

import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.entity.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDto {

    private Integer id;

    private String code;

    private InventoryStatus status;

    private Integer cardId;
}
