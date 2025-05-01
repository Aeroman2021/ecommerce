package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.model.entity.CartItem;
import com.project.ecommerce.model.entity.Order;
import com.project.ecommerce.model.entity.OrderItem;
import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.entity.enums.OrderTypes;
import com.project.ecommerce.model.service.contract.OrderService;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.OrderItemRepository;
import com.project.ecommerce.repository.OrderRepository;
import com.project.ecommerce.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public OrderServiceImpl(CartRepository cartRepository, OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository,
                            TransactionRepository transactionRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Order checkOut(int userId) {
        Cart cart = cartRepository
                .findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not Found"));
        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }

        Order order = orderRepository.save(Order.builder()
                .user(cart.getUser())
                .orderTypes(OrderTypes.PENDING)
                .auditFields(new AuditFields())
                .build());

        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            OrderItem.builder()
                    .order(order)
                    .card(cartItem.getCard())
                    .quantity(cartItem.getQuantity())
                    .auditFields(new AuditFields())
                    .build();
            orderItemRepository.save(orderItem);
        }

        cartRepository.delete(cart);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findOrderByUserId(userId);
    }
}
