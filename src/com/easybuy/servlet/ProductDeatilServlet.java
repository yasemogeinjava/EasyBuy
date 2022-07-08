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

@WebServlet("/productDetail")
public class ProductDeatilServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl ();
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter ("id");
        if (id!=null){
            Product product = productService.findById (Integer.parseInt (id));
            List<ProductCategory> allProductCategory = productCategoryService.findAllProductCategory ();

            List<ProductCategory> categoryList1 = new ArrayList<> ();
            List<ProductCategory> categoryList2 = new ArrayList<> ();
            List<ProductCategory> categoryList3 = new ArrayList<> ();
            for (int i = 0; i < allProductCategory.size (); i++) {
                if (allProductCategory.get (i).getType ()==1) {
                    categoryList1.add (allProductCategory.get (i));
                }
            }

            for (int i = 0; i < allProductCategory.size (); i++) {
                if (allProductCategory.get (i).getType ()==2) {
                    categoryList2.add (allProductCategory.get (i));
                }
            }
            req.setAttribute ("categoryList2",categoryList2);// product_category中二级标题的数据

            for (int i = 0; i < allProductCategory.size (); i++) {
                if (allProductCategory.get (i).getType ()==3) {
                    categoryList3.add (allProductCategory.get (i));
                }
            }
            req.setAttribute ("categoryList3",categoryList3);// product_category中三级标题的数据
            req.setAttribute ("product",product);
            req.setAttribute ("categoryList1",categoryList1);
            req.getRequestDispatcher ("pre/product/productDetail.jsp").forward (req,resp);
        }
    }
}
