package com.easybuy.dao;

import com.easybuy.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAllOrder();

    Order findByUserId(int userId);

    boolean addOrder(Order order);


}
