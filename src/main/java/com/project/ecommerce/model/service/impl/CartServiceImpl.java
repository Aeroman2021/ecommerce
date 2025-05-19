package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.exception.CartFinalizeException;
import com.project.ecommerce.model.Dto.AddToCartDto;
import com.project.ecommerce.model.entity.*;
import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.entity.enums.OrderTypes;
import com.project.ecommerce.model.service.contract.CartService;
import com.project.ecommerce.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository,
                           CardRepository cardRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
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
    @Transactional
    public Cart addToCart(AddToCartDto addToCartDto) {
        int userId = addToCartDto.getUserId();
        int cardId = addToCartDto.getCardId();
        int quantity = addToCartDto.getQuantity();

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> createNewCart(userId));

        if (cart.getStatus() != Cart.CartStatusEnum.ACTIVE) {
            throw new IllegalStateException("Cart is not active and cannot be modified.");
        }

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card Not Found"));

        Optional<CartItem> existingItem = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getCard() != null &&
                        Objects.equals(cartItem.getCard().getId(), cardId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setAuditFields(new AuditFields());
            cartItemRepository.save(cartItem);
        } else {
            CartItem cartItem = CartItem.builder()
                    .cart(cart)
                    .card(card)
                    .quantity(quantity)
                    .auditFields(new AuditFields())
                    .build();

            cartItem = cartItemRepository.save(cartItem);
            cart.getCartItems().add(cartItem);
        }

        cart.setAuditFields(new AuditFields());
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
    public Cart finalizeCart(int cartId) {
        Cart cart =
                cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Card Not Found"));

        if (cart.getStatus() != Cart.CartStatusEnum.ACTIVE) {
            throw new CartFinalizeException("Cart is already finalized or inactive");
        }

        cart.setStatus(Cart.CartStatusEnum.FINALIZED);
        cart.setAuditFields(new AuditFields());

        try{
            cartRepository.save(cart);
        }catch (Exception ex){
            throw new CartFinalizeException("Failed to save cart during finalization: " + ex.getMessage());
        }

        cartRepository.save(cart);
        Order order = Order.builder()
                .cart(cart)
                .orderTypes(OrderTypes.PENDING)
                .auditFields(new AuditFields())
                .build();
        orderRepository.save(order);
        return cart;
    }
}
