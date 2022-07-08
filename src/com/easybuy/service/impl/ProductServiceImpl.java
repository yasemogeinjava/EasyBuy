package com.easybuy.service.impl;

import com.easybuy.dao.ProductDao;
import com.easybuy.dao.impl.ProductDaoImpl;
import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductService;

import java.util.List;



public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl ();
    @Override
    public List<ProductCategory> findAllProductCategory() {
        return productDao.findAllProductCategory ();
    }

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct ();
    }

    @Override
    public List<Product> findBycategoryLevel3Id(int categoryLevel3Id) {
        return productDao.findBycategoryLevel3Id(categoryLevel3Id);
    }

    @Override
    public List<Product> findBycategoryLevel2Id(int categoryLevel2Id) {
        return productDao.findBycategoryLevel2Id (categoryLevel2Id);
    }

    @Override
    public List<Product> findBycategoryLevel1Id(int categoryLevel1Id) {
        return productDao.findBycategoryLevel1Id (categoryLevel1Id);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById (id);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDao.addProduct (product);
    }


    @Override
    public List<Product> findProductListByIdList(int userId, List<Integer> ids) {
        return productDao.findProductListByIdList (userId, ids);
    }

    @Override
    public List<ProductCategory> categoryFindByType(int type) {
        return productDao.categoryFindByType(type);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productDao.deleteById(id);
    }

    @Override
    public boolean addQuantity(int orderId, Product product) {
        return productDao.addQuantity(orderId,product);
    }

    @Override
    public boolean reduceQuantity(int orderId, Product product) {
        return productDao.reduceQuantity(orderId,product);
    }

    @Override
    public int count() {
        return productDao.count ();
    }

    @Override
    public List<Product> PageCategory(int page, int pagesize) {
        return productDao.PageCategory (page,pagesize);
    }
}
