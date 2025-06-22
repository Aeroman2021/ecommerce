package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.Transaction;
import com.project.ecommerce.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends BaseRepository<Transaction,Integer> {
}
