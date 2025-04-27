package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.model.service.contract.CardService;
import com.project.ecommerce.model.service.contract.CartService;
import com.project.ecommerce.repository.CardRepository;
import com.project.ecommerce.repository.CartItemRepository;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository,
                           CardRepository cardRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Cart create(Cart entity) {
        return null;
    }

    @Override
    public Cart update(Integer integer, Cart cart) {
        return null;
    }

    @Override
    public Optional<Cart> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<Cart> getAll() {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void addToCart(int userId, int cardId, int quantity) {


    }

    @Override
    public Cart getCartByUserId(int userId) {

    }

    @Override
    public void removeItem(int userId, int cartItemId) {

    }
}
