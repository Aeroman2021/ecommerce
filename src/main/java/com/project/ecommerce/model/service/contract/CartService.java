package com.project.ecommerce.model.service.contract;

import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.model.service.GenericService;
import org.springframework.stereotype.Service;


public interface CartService extends GenericService<Cart,Integer> {
    void addToCart(int userId, int cardId, int quantity);
    Cart getCartByUserId(int userId);
    void removeItem(int userId, int cartItemId);
}
