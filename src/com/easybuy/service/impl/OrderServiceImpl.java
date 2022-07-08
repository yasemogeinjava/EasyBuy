package com.easybuy.service.impl;

import com.easybuy.dao.OrderDao;
import com.easybuy.dao.impl.OrderDaoImpl;
import com.easybuy.entity.Order;
import com.easybuy.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao=new OrderDaoImpl();

    @Override
    public List<Order> findAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public Order findByUserId(int userId) {
        return orderDao.findByUserId(userId);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDao.addOrder (order);
    }
}
