package com.easybuy.dao.impl;

import com.easybuy.dao.OrderDao;
import com.easybuy.entity.Order;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> findAllOrder() {
        String sql = "select * from easybuy_order";
        ResultSet query = JDBCUtil.query(sql, null);
        List<Order> orderList = new ArrayList<>();

        try{
            while(query.next()){
                Order order = new Order();
                order.setId(query.getInt("id"));
                order.setUserId(query.getInt("userId"));
                order.setLoginName (query.getString ("loginName"));
                order.setCost (query.getDouble ("cost"));
                order.setUserAddress(query.getString("userAddress"));
                order.setCreateTime(query.getDate("createTime"));
                order.setSerialNumber (query.getString ("serialNumber"));
                orderList.add(order);
            }
            return orderList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order findByUserId(int userId) {
        String sql = "select * from easybuy_order where userId = ?";
        Object[] params = {userId};
        ResultSet query = JDBCUtil.query(sql, params);
        Order order = new Order();
        try {
            while (query.next()) {
                order.setId(query.getInt("id"));
                order.setUserId(query.getInt("userId"));
                order.setLoginName (query.getString ("loginName"));
                order.setCost (query.getDouble ("cost"));
                order.setUserAddress(query.getString("userAddress"));
                order.setCreateTime(query.getDate("createTime"));
                order.setSerialNumber (query.getString ("serialNumber"));
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        String sql = "insert into easybuy_order(userId,loginName,userAddress,createTime,cost,serialNumber) value(?,?,?,?,?,?)";
        Object[] params = {order.getUserId (),order.getLoginName (),order.getUserAddress (),order.getCreateTime (),order.getCost(),order.getSerialNumber ()};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }

}
