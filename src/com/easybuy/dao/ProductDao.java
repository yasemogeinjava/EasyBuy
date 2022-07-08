package com.easybuy.dao;

import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;

import java.util.List;

public interface ProductDao {
    //Select * from easybuy_product_category;
    List<ProductCategory> findAllProductCategory();

    //Selcet * from easybuy_product;
    List<Product> findAllProduct();

    Product findById(int id);

    List<Product> findBycategoryLevel3Id(int categoryLevel3Id);

    List<Product> findBycategoryLevel2Id(int categoryLevel2Id);

    List<Product> findBycategoryLevel1Id(int categoryLevel1Id);

    //insert into easybuy_product(id,name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?,?)
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
