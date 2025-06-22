package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.Cart;
import com.project.ecommerce.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends BaseRepository<Cart,Integer> {
    Optional<Cart> findByUserId(int userId);
}
