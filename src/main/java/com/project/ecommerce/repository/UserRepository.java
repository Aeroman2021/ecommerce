package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Integer> {
}
