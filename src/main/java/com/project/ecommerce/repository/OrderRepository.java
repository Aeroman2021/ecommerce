package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.Order;
import com.project.ecommerce.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends BaseRepository<Order,Integer> {
    List<Order> findOrderByUserId(int userId);
}
