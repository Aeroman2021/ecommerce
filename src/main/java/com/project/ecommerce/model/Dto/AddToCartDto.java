package com.project.ecommerce.model.Dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddToCartDto {
    private int userId,cardId,quantity;
}
