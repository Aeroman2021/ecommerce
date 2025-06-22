package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.OrderItem;
import com.project.ecommerce.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends BaseRepository<OrderItem,Integer> {
}
