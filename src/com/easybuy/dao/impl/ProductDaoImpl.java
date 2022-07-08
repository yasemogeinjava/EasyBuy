package com.easybuy.dao.impl;

import com.easybuy.service.DetailService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.DetailSerciceImpl;
import com.easybuy.service.impl.ProductServiceImpl;
import com.easybuy.util.JDBCUtil;
import com.easybuy.dao.ProductDao;
import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<ProductCategory> findAllProductCategory() {
        String sql = "select * from easybuy_product_category";
        ResultSet query = JDBCUtil.query (sql,null);
        List<ProductCategory> pcList = new ArrayList<> ();
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
    public List<Product> findAllProduct() {
        String sql = "select * from easybuy_product";
        ResultSet query = JDBCUtil.query (sql, null);
        List<Product> pList = new ArrayList<> ();
        try{
            while (query.next ()){
                Product product = new Product ();
                product.setId (query.getInt ("id"));
                product.setName (query.getString ("name"));
                product.setDescription (query.getString ("description"));
                product.setPrice (query.getDouble ("price"));
                product.setStock (query.getInt ("stock"));
                product.setCategoryLevel1Id (query.getInt ("categoryLevel1Id"));
                product.setCategoryLevel2Id (query.getInt ("categoryLevel2Id"));
                product.setCategoryLevel3Id (query.getInt ("categoryLevel3Id"));
                product.setFileName (query.getString ("fileName"));
                product.setIsDelete (query.getInt ("isDelete"));
                pList.add (product);
            }
            return pList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<Product> findBycategoryLevel3Id(int categoryLevel3Id) {
        String sql = "select * from easybuy_product where categoryLevel3Id =?";
        Object[] params = {categoryLevel3Id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
            List<Product> productList = new ArrayList<> ();
            while (query.next()){
                if (categoryLevel3Id>0) {
                    Product product = new Product ();
                    product.setId (query.getInt ("id"));
                    product.setName (query.getString ("name"));
                    product.setDescription (query.getString ("description"));
                    product.setPrice (query.getDouble ("price"));
                    product.setStock (query.getInt ("stock"));
                    product.setCategoryLevel1Id (query.getInt ("categoryLevel1Id"));
                    product.setCategoryLevel2Id (query.getInt ("categoryLevel2Id"));
                    product.setCategoryLevel3Id (query.getInt ("categoryLevel3Id"));
                    product.setFileName (query.getString ("fileName"));
                    product.setIsDelete (query.getInt ("isDelete"));
                    productList.add (product);
                }
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findBycategoryLevel2Id(int categoryLevel2Id) {
        String sql = "select * from easybuy_product where categoryLevel2Id =?";
        Object[] params = {categoryLevel2Id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
            List<Product> productList = new ArrayList<> ();
            while (query.next()){
                if (categoryLevel2Id>0) {
                    Product product = new Product ();
                    product.setId (query.getInt ("id"));
                    product.setName (query.getString ("name"));
                    product.setDescription (query.getString ("description"));
                    product.setPrice (query.getDouble ("price"));
                    product.setStock (query.getInt ("stock"));
                    product.setCategoryLevel1Id (query.getInt ("categoryLevel1Id"));
                    product.setCategoryLevel2Id (query.getInt ("categoryLevel2Id"));
                    product.setCategoryLevel3Id (query.getInt ("categoryLevel3Id"));
                    product.setFileName (query.getString ("fileName"));
                    product.setIsDelete (query.getInt ("isDelete"));
                    productList.add (product);
                }
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findBycategoryLevel1Id(int categoryLevel1Id) {
        String sql = "select * from easybuy_product where categoryLevel1Id =?";
        Object[] params = {categoryLevel1Id};
        ResultSet query = JDBCUtil.query(sql, params);
        try {
            List<Product> productList = new ArrayList<> ();
            while (query.next()){
                if (categoryLevel1Id>0) {
                    Product product = new Product ();
                    product.setId (query.getInt ("id"));
                    product.setName (query.getString ("name"));
                    product.setDescription (query.getString ("description"));
                    product.setPrice (query.getDouble ("price"));
                    product.setStock (query.getInt ("stock"));
                    product.setCategoryLevel1Id (query.getInt ("categoryLevel1Id"));
                    product.setCategoryLevel2Id (query.getInt ("categoryLevel2Id"));
                    product.setCategoryLevel3Id (query.getInt ("categoryLevel3Id"));
                    product.setFileName (query.getString ("fileName"));
                    product.setIsDelete (query.getInt ("isDelete"));
                    productList.add (product);
                }
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        String sql = " select * from easybuy_product where id = ?";
        Object[] params ={id};
        ResultSet query = JDBCUtil.query (sql, params);
        try{
            Product product = new Product ();
            while (query.next ()){
                product.setId (query.getInt ("id"));
                product.setName (query.getString ("name"));
                product.setDescription (query.getString ("description"));
                product.setPrice (query.getDouble ("price"));
                product.setStock (query.getInt ("stock"));
                product.setCategoryLevel1Id (query.getInt ("categoryLevel1Id"));
                product.setCategoryLevel2Id (query.getInt ("categoryLevel2Id"));
                product.setCategoryLevel3Id (query.getInt ("categoryLevel3Id"));
                product.setFileName (query.getString ("fileName"));
                product.setIsDelete (query.getInt ("isDelete"));
                return product;
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        String sql = "insert into easybuy_product(id,name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {product.getId (),product.getName (),product.getDescription (),product.getPrice (),product.getStock (),product.getCategoryLevel1Id (),product.getCategoryLevel2Id (),product.getCategoryLevel3Id (),product.getFileName (),product.getIsDelete ()};
        int update = JDBCUtil.update (sql, params);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findProductListByIdList(int userId,List<Integer> ids) {
        DetailService detailService = new DetailSerciceImpl();
        ProductService productService = new ProductServiceImpl();
//            String sql = " select * from easybuy_product where ids in ?";
//        String sql = "select * from easybuy_product where a [ids] in (’id’)";
        String sql = "select * from easybuy_product where id in(";
        for (int i = 0; i < ids.size()-1; i++) {
            sql=sql+"?,";
        }
        sql=sql+"?)";
        System.out.println(sql);
        Object[] params =ids.toArray();
        ResultSet query = JDBCUtil.query (sql, params);
        try{
            List<Product> productList = new ArrayList<>();
            while (query.next ()){
                Product product = new Product ();
                product.setId (query.getInt ("id"));
                product.setName (query.getString ("name"));
                product.setDescription (query.getString ("description"));
                product.setPrice (query.getDouble ("price"));
                product.setStock (query.getInt ("stock"));
                product.setCategoryLevel1Id (query.getInt ("categoryLevel1Id"));
                product.setCategoryLevel2Id (query.getInt ("categoryLevel2Id"));
                product.setCategoryLevel3Id (query.getInt ("categoryLevel3Id"));
                product.setFileName (query.getString ("fileName"));
                product.setIsDelete (query.getInt ("isDelete"));
//                findQuantityByOrderIdAndProductId(int orderId, int productId)
                product.setQuantity(detailService.findQuantityByOrderIdAndProductId(detailService.orderIdFindByUserId(userId),query.getInt("id")));  //通过id返回商品的数量
//                product.setCost(query.getInt("price")*product.getQuantity());
                productList.add(product);
            }return productList;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return null;
    }

    @Override
    public List<ProductCategory> categoryFindByType(int type) {
        String sql = "select * from easybuy_product_category where type = ?";
        Object[] params = {type};
        ResultSet query = JDBCUtil.query(sql, params);
        List<ProductCategory> productCategories = new ArrayList<>();
        try {
            while (query.next()){
                ProductCategory productCategory = new ProductCategory();
                productCategory.setId(query.getInt("id"));
                productCategory.setName(query.getString("name"));
                productCategory.setParentId(query.getInt("parentId"));
                productCategory.setType(query.getInt("type"));
                productCategory.setIconClass(query.getString("iconClass"));
                productCategories.add(productCategory);
            }
            return productCategories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql = "update easybuy_product set name=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=? where id=?";
        Object[] params = {product.getName(),product.getDescription(),product.getPrice(),product.getStock(),product.getCategoryLevel1Id(),product.getCategoryLevel2Id(),
                product.getCategoryLevel3Id(),product.getFileName(), product.getId()};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteById(int id) {
        String sql = "delete from easybuy_product where id = ?";
        Object[] params= {id};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addQuantity(int orderId,Product product) {
        String sql = "update easybuy_order_detail set quantity = quantity+1 where productId=?&&orderId =?;";
//        try {

        Object[] params= {product.getId(),orderId};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean reduceQuantity(int orderId, Product product) {
        String sql = "update easybuy_order_detail set quantity = quantity-1 where productId=?&&orderId =?;";
        Object[] params = {product.getId(), orderId};
        int update = JDBCUtil.update(sql, params);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        String sql="select count(1) as total from easybuy_product";
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
    public List<Product> PageCategory(int page, int pagesize) {
        String sql="select * from easybuy_product limit ?,?";
        Object[] params={pagesize*(page-1),pagesize};
        ResultSet query = JDBCUtil.query(sql, params);
        List<Product> productList=new ArrayList<>();
        try {
            while (query.next()){
                Product product = new Product();
                product.setId(query.getInt("id"));
                product.setDescription(query.getString("description"));
                product.setCategoryLevel1Id(query.getInt("categoryLevel1Id"));
                product.setCategoryLevel2Id(query.getInt("categoryLevel2Id"));
                product.setCategoryLevel3Id(query.getInt("categoryLevel3Id"));
                product.setFileName(query.getString("fileName"));
                product.setIsDelete(query.getInt("isDelete"));
                product.setName(query.getString("name"));
                product.setPrice(query.getDouble("price"));
                product.setStock(query.getInt("stock"));
                productList.add(product);
            }
            return productList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
