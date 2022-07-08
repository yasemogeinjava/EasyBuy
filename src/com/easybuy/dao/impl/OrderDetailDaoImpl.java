package com.easybuy.dao.impl;

import com.easybuy.dao.OrderDetailDao;
import com.easybuy.entity.Order;
import com.easybuy.entity.OrderDetail;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public List<OrderDetail> findAll() {
        String sql = "select * from easybuy_order_detail";
        ResultSet query = JDBCUtil.query(sql, null);
        List<OrderDetail> orderDetailList = new ArrayList<>();

        try{
            while(query.next()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(query.getInt("id"));
                orderDetail.setOrderId(query.getInt("orderId"));
                orderDetail.setProductId(query.getInt("productId"));
                orderDetail.setQuantity(query.getInt("quantity"));
                orderDetail.setCost (query.getDouble ("cost"));
                orderDetailList.add(orderDetail);
            }
            return orderDetailList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrderDetail findByOrderId(int orderId) {
        String sql = "select * from easybuy_order_detail where orderId = ?";
        Object[] params = {orderId};
        ResultSet query = JDBCUtil.query(sql, params);
        OrderDetail orderDetail = new OrderDetail();
        try {
            while (query.next()) {
                orderDetail.setId(query.getInt("id"));
                orderDetail.setOrderId(query.getInt("orderId"));
                orderDetail.setProductId(query.getInt("productId"));
                orderDetail.setQuantity(query.getInt("quantity"));
                orderDetail.setCost (query.getDouble ("cost"));
            }
            return orderDetail;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        String sql = "insert into easybuy_order_detail(orderId,productId,quantity,cost) value(?,?,?,?)";
        Object[] params = {orderDetail.getOrderId(),orderDetail.getProductId(),orderDetail.getQuantity(),orderDetail.getCost()};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }
}
