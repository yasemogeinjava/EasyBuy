package com.easybuy.dao.impl;

import com.easybuy.dao.DetailDao;
import com.easybuy.entity.Detail;
import com.easybuy.entity.Order;
import com.easybuy.entity.Product;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailDaoImpl implements DetailDao {

    //根据orderId查找此用户下所有订单
    @Override
    public Detail findOrderById(int id) {
        String sql ="select * from easybuy_order_detail where orderId =?";
        Object[] params={id};
        ResultSet query = JDBCUtil.query(sql,params);
        try {
            Detail detail = new Detail();
            while (query.next()){
                System.out.println(id);
                if(detail.getId()==null){
//                       id,orderId,productId,quantity,cost
                    detail.setId(query.getInt("id"));
                    detail.setOrderId(query.getInt("orderId"));
                    detail.setProductId(query.getInt("productId"));
                    detail.setQuantity(query.getInt("quantity"));
                    detail.setCost(query.getInt("cost"));
                }
            }return detail;
        }catch  (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int orderIdFindByUserId(int id) {
        String sql ="select * from easybuy_order where userId =?";
        Object[] params={id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
           Order order = new Order();
            while (query.next()){
                System.out.println(id);
                if(order.getId()==null){
                    order.setId(query.getInt("id"));
                }
            }return order.getId();
        }catch  (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> productIdFindByorderId(int id) {
        String sql ="select * from easybuy_order_detail where orderId =?";
        Object[] params={id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
            List<Integer> ids = new ArrayList<>();
            while (query.next()){
                ids.add(query.getInt("productId"));
            }
            return ids;
        }catch  (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int findQuantityByOrderIdAndProductId(int orderId,int productId) {
//        String sql = "select quantity from easybuy_order_detail where orderId=? and productId=?;";
        String sql = "select * from easybuy_order_detail where  productId=?;";
        Object[] params={productId};
        ResultSet query = JDBCUtil.query(sql, params);

        int quantity = 0;
        try {
            while (query.next()){
                if (Integer.parseInt(String.valueOf(query.getInt("orderId"))) == orderId) {
                    quantity = query.getInt("quantity");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
}
