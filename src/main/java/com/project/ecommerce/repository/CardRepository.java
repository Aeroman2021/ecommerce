package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends BaseRepository<Card,Integer> {
}
