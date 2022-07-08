package com.easybuy.service.impl;

import com.easybuy.dao.DetailDao;
import com.easybuy.dao.impl.DetailDaoImpl;
import com.easybuy.entity.Detail;
import com.easybuy.entity.Order;
import com.easybuy.service.DetailService;

import java.util.List;

public class DetailSerciceImpl implements DetailService {
    private  DetailDao detailDao = new DetailDaoImpl();

    @Override
    public int orderIdFindByUserId(int id) {
        return detailDao.orderIdFindByUserId(id);
    }

    @Override
    public List<Integer> productIdFindByorderId(int id){
        return  detailDao.productIdFindByorderId(id);
    }

    @Override
    public int findQuantityByOrderIdAndProductId(int orderId, int productId) {
        return detailDao.findQuantityByOrderIdAndProductId(orderId,productId);
    }
}
