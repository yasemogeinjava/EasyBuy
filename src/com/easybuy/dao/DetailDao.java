package com.easybuy.dao;
import com.easybuy.entity.Detail;

import java.util.List;

public interface DetailDao {
    Detail findOrderById(int id); //根据orderId查找此用户下所有订单
    int orderIdFindByUserId(int id);//根据用户id查找对应的所有订单id
    List<Integer> productIdFindByorderId(int id);//根据订单id查找对应的所有商品id
    int findQuantityByOrderIdAndProductId(int orderId,int productId);
}
