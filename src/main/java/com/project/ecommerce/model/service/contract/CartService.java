package com.project.ecommerce.model.service.contract;

import com.project.ecommerce.model.Dto.AddToCartDto;
import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.model.service.GenericService;


public interface CartService extends GenericService<Cart,Integer> {
    Cart addToCart(AddToCartDto addToCartDto);
    Cart getCartByUserId(int userId);
    void removeItem(int userId, int cartItemId);
}
