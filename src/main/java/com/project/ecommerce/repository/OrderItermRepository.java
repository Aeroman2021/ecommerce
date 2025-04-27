package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItermRepository  extends JpaRepository<OrderItem,Integer> {
}
