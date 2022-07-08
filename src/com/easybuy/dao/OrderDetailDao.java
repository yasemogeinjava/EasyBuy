package com.easybuy.dao;

import com.easybuy.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    List<OrderDetail> findAll();

    OrderDetail findByOrderId(int orderId);

    boolean addOrderDetail(OrderDetail orderDetail);
}
