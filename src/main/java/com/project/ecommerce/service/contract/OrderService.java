package com.project.ecommerce.service.contract;

import com.project.ecommerce.model.entity.Order;

import java.util.List;


public interface OrderService  {
    Order checkOut(int userId);
    List<Order>  getOrdersByUserId(int userId);


}
