package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.model.entity.CartItem;
import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.model.service.contract.CardService;
import com.project.ecommerce.model.service.contract.CartService;
import com.project.ecommerce.repository.CardRepository;
import com.project.ecommerce.repository.CartItemRepository;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public Cart create(Cart cart) {
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
        Cart cart =
                cartRepository.findByUserId(userId).orElse(createNewCart(userId));
        Optional<CartItem> existingItem = cart.getCartItems()
                .stream()
                .filter(cartItem -> cartItem.getCard().getId() == cardId)
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            Card card = cardRepository
                    .findById(cardId)
                    .orElseThrow(() -> new RuntimeException("Card Not found"));

            CartItem cartItem = cartItemRepository.save(
                    CartItem.builder()
                            .cart(cart).card(card).quantity(quantity).build());
            cart.getCartItems().add(cartItem);
        }
        cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUserId(int userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("car not found"));
    }

    @Override
    public void removeItem(int userId, int cartItemId) {
        Cart cart =
                cartRepository.findByUserId(userId).orElseThrow(
                        () -> new RuntimeException("cart not found"));
        cart.getCartItems().removeIf(item->item.getId() == cartItemId);
        cartRepository.save(cart);
    }

    private Cart createNewCart(int userId) {
        User user =
                userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        return cartRepository.save(Cart.builder()
                .user(user)
                .cartItems(new HashSet<>())
                .build());

    }
}
