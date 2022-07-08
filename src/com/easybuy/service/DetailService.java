package com.easybuy.service;

import com.easybuy.entity.Detail;
import com.easybuy.entity.Order;

import java.util.List;

public interface DetailService {
    int orderIdFindByUserId(int id);//根据用户id查找对应的所有订单id
    List<Integer> productIdFindByorderId(int id);//根据订单id查找对应的所有商品id
    int findQuantityByOrderIdAndProductId(int orderId,int productId);
}
