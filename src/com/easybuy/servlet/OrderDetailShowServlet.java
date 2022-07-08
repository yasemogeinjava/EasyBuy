package com.easybuy.servlet;

import com.easybuy.entity.Cart;
import com.easybuy.entity.OrderDetail;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orderDetailShow")
public class OrderDetailShowServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private ProductCategoryService productCategoryService =new ProductCategoryServiceImpl ();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSessionn = req.getSession();
//        req.getRequestDispatcher("").forward(req,resp);
        List<ProductCategory> categoryList = productService.findAllProductCategory ();
        req.setAttribute ("categoryList",categoryList);  // product_category中所有的数据
//        List<Product> pList = productService.findAllProduct ();
//        req.setAttribute ("pList",pList);
        List<ProductCategory> categoryList1 = new ArrayList<>();
        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==1) {
                categoryList1.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList1",categoryList1);// product_category中一级标题的数据

//        httpSessionn.setAttribute("totalPrice",totalPrice);
        req.getRequestDispatcher("pre/settlement/toSettlement.jsp").forward(req,resp);
    }
}
