package com.easybuy.service.impl;

import com.easybuy.dao.ProductCategoryDao;
import com.easybuy.dao.impl.ProductCategoryDaoImpl;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryDao productCategoryDao = new ProductCategoryDaoImpl();

    @Override
    public List<ProductCategory> findAllProductCategory() {
        return productCategoryDao.findAllProductCategory();
    }

    @Override
    public boolean addProductCategory(ProductCategory productCategory) {
        return productCategoryDao.addProductCategory(productCategory);
    }

    @Override
    public boolean deleteById(int id) {
        return productCategoryDao.deleteById(id);
    }

    @Override
    public List<ProductCategory> findById(int id) {
        return productCategoryDao.findById(id);
    }

    @Override
    public List<ProductCategory> findByParentId(int parentId) {
        return productCategoryDao.findByParentId(parentId);
    }

    @Override
    public List<ProductCategory> findBytype(int type) {
        return productCategoryDao.findBytype(type);
    }

    @Override
    public List<ProductCategory> findByName(String name) {
        return productCategoryDao.findByName(name);
    }

    @Override
    public int countNumber() {
        return productCategoryDao.countNumber();
    }

    @Override
    public List<ProductCategory> findPcPage(int page, int pageSize) {
        return productCategoryDao.findPcPage(page,pageSize);
    }

    @Override
    public int count() {
        return productCategoryDao.count ();
    }

    @Override
    public List<ProductCategory> PageCategory(int page, int pagesize) {
        return productCategoryDao.PageCategory (page,pagesize);
    }

    @Override
    public String FindparentNameById(int i) {
        return productCategoryDao.FindparentNameById (i);
    }
}
