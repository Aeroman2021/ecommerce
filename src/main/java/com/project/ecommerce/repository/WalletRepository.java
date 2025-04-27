package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}
