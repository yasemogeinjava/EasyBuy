//package com.easybuy.servlet;
//
//import com.easybuy.entity.Product;
//import com.easybuy.entity.User;
//import com.easybuy.service.DetailService;
//import com.easybuy.service.ProductService;
//import com.easybuy.service.impl.DetailSerciceImpl;
//import com.easybuy.service.impl.ProductServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/modifyCartReduce")
//public class modifyCartReduce extends HttpServlet {
//    ProductService productService = new ProductServiceImpl();
//    DetailService detailService = new DetailSerciceImpl();
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession httpSession = req.getSession();
//        User user = (User) httpSession.getAttribute("loginUser");
//        int userId = user.getId();
//        String quantity = req.getParameter("quantity");
//        String productId = req.getParameter("entityId");//获取的商品id
//        Product product = productService.findById(Integer.parseInt(productId));//通过id查找商品
//        int orderId = detailService.orderIdFindByUserId(userId);
//
//        productService.reduceQuantity(orderId,product);
//        req.getRequestDispatcher("orderDetailfindById").forward(req,resp);
//    }
//}
