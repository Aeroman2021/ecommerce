package com.project.ecommerce.service.contract;

import com.project.ecommerce.model.Dto.AddToCartDto;
import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.dao.GenericDao;


public interface CartService extends GenericDao<Cart,Integer> {
    Cart addToCart(AddToCartDto addToCartDto);
    Cart finalizeCart(int cartId);
    Cart getCartByUserId(int userId);
    void removeItem(int userId, int cartItemId);
}
