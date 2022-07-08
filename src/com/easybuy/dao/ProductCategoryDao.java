package com.easybuy.dao;

import com.easybuy.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {

    List<ProductCategory> findAllProductCategory();

    boolean addProductCategory(ProductCategory productCategory);

    boolean deleteById(int id);

    List<ProductCategory> findById(int id);

    List<ProductCategory> findByParentId(int parentId);

    List<ProductCategory> findBytype(int type);

    List<ProductCategory> findByName(String name);

    int countNumber();

    List<ProductCategory> findPcPage(int page, int pageSize);


    int count();

    List<ProductCategory> PageCategory(int page,int pagesize);


    String FindparentNameById(int i);
}
