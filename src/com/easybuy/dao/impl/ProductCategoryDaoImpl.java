package com.easybuy.dao.impl;

import com.easybuy.dao.ProductCategoryDao;
import com.easybuy.entity.ProductCategory;
import com.easybuy.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoImpl implements ProductCategoryDao {
    @Override
    public List<ProductCategory> findAllProductCategory() {
        String sql = "select * from easybuy_product_category";
        ResultSet query = JDBCUtil.query (sql,null);
        List<ProductCategory> pcList = new ArrayList<>();
        try{
            while (query.next ()){
                ProductCategory productCategory = new ProductCategory ();
                productCategory.setId (query.getInt ("id"));
                productCategory.setName (query.getString ("name"));
                productCategory.setParentId (query.getInt ("parentId"));
                productCategory.setType (query.getInt ("type"));
                productCategory.setIconClass (query.getString ("iconClass"));
                pcList.add (productCategory);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public boolean addProductCategory(ProductCategory productCategory) {
        String sql = "insert into easybuy_product_category(id,name,parentId,type,iconClass) values(?,?,?,?,?)";
        Object[] params = {productCategory.getId(),productCategory.getName(),productCategory.getParentId(),productCategory.getType()};
        int update = JDBCUtil.update(sql, params);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        String sql ="delete from easybuy_product_category where id =?";
        Object[] params = {id};
        int update = JDBCUtil.update(sql, params);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public List<ProductCategory> findById(int id) {
        String sql = "select * from easybuy_product_category where id=?";
        ResultSet query = JDBCUtil.query (sql,null);
        List<ProductCategory> pcList = new ArrayList<>();
        try{
            while (query.next ()){
                ProductCategory productCategory = new ProductCategory ();
                productCategory.setId (query.getInt ("id"));
                productCategory.setName (query.getString ("name"));
                productCategory.setParentId (query.getInt ("parentId"));
                productCategory.setType (query.getInt ("type"));
                productCategory.setIconClass (query.getString ("iconClass"));
                pcList.add (productCategory);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<ProductCategory> findByParentId(int parentId) {
        String sql = "select * from easybuy_product_category where parentId=?";
        ResultSet query = JDBCUtil.query (sql,null);
        List<ProductCategory> pcList = new ArrayList<>();
        try{
            while (query.next ()){
                ProductCategory productCategory = new ProductCategory ();
                productCategory.setId (query.getInt ("id"));
                productCategory.setName (query.getString ("name"));
                productCategory.setParentId (query.getInt ("parentId"));
                productCategory.setType (query.getInt ("type"));
                productCategory.setIconClass (query.getString ("iconClass"));
                pcList.add (productCategory);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<ProductCategory> findBytype(int type) {
        String sql = "select * from easybuy_product_category where type=?";
        ResultSet query = JDBCUtil.query (sql,null);
        List<ProductCategory> pcList = new ArrayList<>();
        try{
            while (query.next ()){
                ProductCategory productCategory = new ProductCategory ();
                productCategory.setId (query.getInt ("id"));
                productCategory.setName (query.getString ("name"));
                productCategory.setParentId (query.getInt ("parentId"));
                productCategory.setType (query.getInt ("type"));
                productCategory.setIconClass (query.getString ("iconClass"));
                pcList.add (productCategory);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<ProductCategory> findByName(String name) {
        String sql = "select * from easybuy_product_category where name=?";
        ResultSet query = JDBCUtil.query (sql,null);
        List<ProductCategory> pcList = new ArrayList<>();
        try{
            while (query.next ()){
                ProductCategory productCategory = new ProductCategory ();
                productCategory.setId (query.getInt ("id"));
                productCategory.setName (query.getString ("name"));
                productCategory.setParentId (query.getInt ("parentId"));
                productCategory.setType (query.getInt ("type"));
                productCategory.setIconClass (query.getString ("iconClass"));
                pcList.add (productCategory);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public int countNumber() {
        String sql = "select count(1) as total  from easybuy_product_category ";
        ResultSet resultSet = JDBCUtil.query(sql,null);
        try {
            while (resultSet.next()){
                int total= resultSet.getInt("total");
                return total;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ProductCategory> findPcPage(int page, int pageSize) {
        String sql="select * from easybuy_product_category limit ?,?";
        Object[] params={pageSize*(page-1),pageSize};
        ResultSet query = JDBCUtil.query(sql, params);
        List<ProductCategory> pcList = new ArrayList<>();
        try{
            while(query.next()){
                ProductCategory productCategory = new ProductCategory ();
                productCategory.setId (query.getInt ("id"));
                productCategory.setName (query.getString ("name"));
                productCategory.setParentId (query.getInt ("parentId"));
                productCategory.setType (query.getInt ("type"));
                productCategory.setIconClass (query.getString ("iconClass"));
                pcList.add (productCategory);
            }
            return pcList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count() {
        String sql="select count(1) as total from easybuy_product_category";
        ResultSet query = JDBCUtil.query(sql, null);
        try {
            if(query.next()){
                int i=query.getInt("total");
                return i;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<ProductCategory> PageCategory(int page, int pagesize) {
        String sql="select * from easybuy_product_category limit ?,?";
        Object[] params={pagesize*(page-1),pagesize};
        ResultSet query = JDBCUtil.query(sql, params);
        List<ProductCategory> categoryList=new ArrayList<>();
        try{
            while (query.next()){
                ProductCategory category = new ProductCategory();
                category.setId(query.getInt("id"));
                category.setName(query.getString("name"));
                category.setParentId(query.getInt("parentId"));
                category.setType(query.getInt("type"));
                category.setIconClass(query.getString("iconClass"));
                categoryList.add(category);
            }
            return categoryList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String FindparentNameById(int i) {
        String sql="select * from easybuy_product_category where id=?";
        Object param[]={i};
        ResultSet query = JDBCUtil.query(sql, param);
        String name=null;
        try{
            while (query.next()){
                name=query.getString("name");
            }
            return name;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
