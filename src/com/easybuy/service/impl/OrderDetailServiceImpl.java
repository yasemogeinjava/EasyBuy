package com.easybuy.service.impl;

import com.easybuy.dao.OrderDetailDao;
import com.easybuy.dao.impl.OrderDetailDaoImpl;
import com.easybuy.entity.OrderDetail;
import com.easybuy.service.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
    @Override
    public List<OrderDetail> findAllDetail() {
        return orderDetailDao.findAll();
    }

    @Override
    public OrderDetail findByOrderId(int orderId) {
        return orderDetailDao.findByOrderId(orderId);
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.addOrderDetail(orderDetail);
    }
}
