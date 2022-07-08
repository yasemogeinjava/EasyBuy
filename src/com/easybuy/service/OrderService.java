package com.easybuy.service;

import com.easybuy.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrder();

    Order findByUserId(int userId);

    boolean addOrder(Order order);

}
