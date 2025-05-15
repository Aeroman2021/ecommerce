package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.Dto.AddToCartDto;
import com.project.ecommerce.model.entity.*;
import com.project.ecommerce.model.entity.embedables.AuditFields;
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
    public Cart addToCart(AddToCartDto addToCartDto) {
        int userId = addToCartDto.getUserId();
        int cardId = addToCartDto.getCardId();
        int quantity = addToCartDto.getQuantity();


        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
        Cart cart;
        if(optionalCart.isEmpty()){
            cart = createNewCart(userId);
        }else{
            cart = optionalCart.get();
        }

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card Not Found"));

        Optional<CartItem> existingItem = cart.getCartItems()
                .stream()
                .filter(cartItem -> cartItem.getCard() != null && cartItem.getCard().getId() == cardId)
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setAuditFields(new AuditFields());
            cartItemRepository.save(cartItem);

        } else {
            CartItem cartItem = cartItemRepository.save(
                    CartItem.builder()
                            .cart(cart)
                            .card(card)
                            .quantity(quantity)
                            .auditFields(new AuditFields())
                            .build());
            cartItem = cartItemRepository.save(cartItem);
            cart.getCartItems().add(cartItem);
        }
        return cartRepository.save(cart);
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

    @Override
    public void finalizeCart(int cartId) {
        Cart cart =
                cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Card Not Found"));
        cart.setStatus(Cart.CartStatusEnum.FINALIZED);
        cart.setAuditFields(new AuditFields());
        cartRepository.save(cart);
        Order order = new Order();
    }
}
