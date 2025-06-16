package com.project.ecommerce.model.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class CardDto {

    private Integer id;

    private BigDecimal price;

    private  BigDecimal irPrice;

    private int cardTypeId;

    private List<Integer> inventoryListIds;

    private String descriptionFa;

    private String descriptionEn;

    private int regionId;
}
