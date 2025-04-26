package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
