package com.easybuy.servlet;

import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl ();
    private ProductService productService = new ProductServiceImpl ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> allProduct = productService.findAllProduct ();
        List<Product> products = new ArrayList<> ();
        List<ProductCategory> allProductCategory = productCategoryService.findAllProductCategory ();
        String keyWord = req.getParameter ("keyWord");
        for (int i = 0; i < allProduct.size (); i++) {
            if (allProduct.get (i).getName ().contains (keyWord)){
                products.add (allProduct.get (i));
            }
        }
        for (int i = 0; i <allProductCategory.size (); i++) {
            if (allProductCategory.get (i).getName ().contains (keyWord)){
                if (allProductCategory.get (i).getType ()==1){
                    for (int j = 0; j < allProduct.size (); j++) {
                        if (allProduct.get (j).getCategoryLevel1Id ()==allProductCategory.get (i).getId ()){
                            products.add (allProduct.get (j));
                        }
                    }
                }else if (allProductCategory.get (i).getType ()==2){
                    for (int j = 0; j < allProduct.size (); j++) {
                        if (allProduct.get (j).getCategoryLevel2Id ()==allProductCategory.get (i).getId ()){
                            products.add (allProduct.get (j));
                        }
                    }
                }else if (allProductCategory.get (i).getType ()==3){
                    for (int j = 0; j < allProduct.size (); j++) {
                        if (allProduct.get (j).getCategoryLevel3Id ()==allProductCategory.get (i).getId ()){
                            products.add (allProduct.get (j));
                        }
                    }
                }
            }
        }
        List<ProductCategory> categoryList = productService.findAllProductCategory ();
        req.setAttribute ("categoryList",categoryList);  // product_category中所有的数据
        List<Product> pList = productService.findAllProduct ();
        req.setAttribute ("pList",pList);
        List<ProductCategory> categoryList1 = new ArrayList<> ();
        List<ProductCategory> categoryList2 = new ArrayList<> ();
        List<ProductCategory> categoryList3 = new ArrayList<> ();
        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==1) {
                categoryList1.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList1",categoryList1);// product_category中一级标题的数据

        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==2) {
                categoryList2.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList2",categoryList2);// product_category中二级标题的数据

        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==3) {
                categoryList3.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList3",categoryList3);// product_category中三级标题的数据
        req.setAttribute ("product",products);
        req.getRequestDispatcher ("pre/product/queryProductList.jsp").forward (req,resp);
    }
}
