package com.easybuy.service;

import com.easybuy.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAllDetail();

    OrderDetail findByOrderId(int orderId);

    boolean addOrderDetail(OrderDetail orderDetail);
}
