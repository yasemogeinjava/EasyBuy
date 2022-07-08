package com.easybuy.servlet;

import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/productFindById")
public class ProductFindByIdServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> categoryList = productService.findAllProductCategory ();
        req.setAttribute ("categoryList",categoryList);  // product_category中所有的数据
        List<Product> pList = productService.findAllProduct ();
        req.setAttribute ("temp.productList",pList);
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


        String cagetoryLevel3Id = req.getParameter ("cagetoryLevel3Id");
        String cagetoryLevel2Id = req.getParameter ("cagetoryLevel2Id");
        String cagetoryLevel1Id = req.getParameter ("cagetoryLevel1Id");

        if (cagetoryLevel3Id!=null){
            List<Product> product = productService.findBycategoryLevel3Id (Integer.parseInt (cagetoryLevel3Id));
            req.setAttribute ("product",product);
            req.getRequestDispatcher ("pre/product/queryProductList.jsp").forward (req,resp);
        }else if (cagetoryLevel2Id!=null){
            List<Product> product = productService.findBycategoryLevel2Id (Integer.parseInt (cagetoryLevel2Id));
            req.setAttribute ("product",product);
            req.getRequestDispatcher ("pre/product/queryProductList.jsp").forward (req,resp);
        }else if (cagetoryLevel1Id!=null){
            List<Product> product = productService.findBycategoryLevel1Id (Integer.parseInt (cagetoryLevel1Id));
            req.setAttribute ("product",product);
            req.getRequestDispatcher ("pre/product/queryProductList.jsp").forward (req,resp);
        }
    }
}
