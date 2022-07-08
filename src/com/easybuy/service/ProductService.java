package com.easybuy.service;

import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;

import java.util.List;

public interface ProductService {
    List<ProductCategory> findAllProductCategory();

    List<Product> findAllProduct();

    List<Product> findBycategoryLevel3Id(int categoryLevel3Id);

    List<Product> findBycategoryLevel2Id(int categoryLevel2Id);

    List<Product> findBycategoryLevel1Id(int categoryLevel1Id);

    Product findById(int id);

    boolean addProduct(Product product);

    List<Product> findProductListByIdList(int userId,List<Integer> ids);

    List<ProductCategory> categoryFindByType(int type);

    boolean updateProduct(Product product);

    boolean deleteById(int id);

    boolean addQuantity(int orderId,Product product);

    boolean reduceQuantity(int orderId,Product product);

    int count();
    List<Product> PageCategory(int page,int pagesize);
}
