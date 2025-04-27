package com.project.ecommerce.model.service.contract;

import com.project.ecommerce.model.entity.Order;
import com.project.ecommerce.model.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends GenericService<Order,Integer> {
}
