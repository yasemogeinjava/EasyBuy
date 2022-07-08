package com.easybuy.servlet;

import com.easybuy.entity.Order;
import com.easybuy.entity.OrderDetail;
import com.easybuy.entity.Product;
import com.easybuy.entity.User;
import com.easybuy.service.OrderDetailService;
import com.easybuy.service.OrderService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.OrderDetailServiceImpl;
import com.easybuy.service.impl.OrderServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet("/addOrderDetail")
public class OrderDetailAddServlet1 extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl ();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("loginUser");
        int orderId = user.getId();
        List<Order> allOrder = orderService.findAllOrder ();
        int id = 0;
        for (int i = 0; i < allOrder.size (); i++) {
            if (orderId==allOrder.get (i).getUserId ()){
                id = allOrder.get (i).getId ();
            }
        }
        String productId = req.getParameter("entityId");
        String quantity = req.getParameter("quantity");
        if (productId != null) {
            Product product = productService.findById(Integer.parseInt(productId));
            double price = product.getPrice ();
            OrderDetail orderDetail = new OrderDetail();
            if (orderId != 0) {
                orderDetail.setOrderId(id);
                orderDetail.setProductId(Integer.parseInt(productId));
                orderDetail.setQuantity(Integer.parseInt(quantity));
                orderDetail.setCost(price);
                boolean b= orderDetailService.addOrderDetail(orderDetail);
                ObjectMapper objectMapper = new ObjectMapper();
                String s = objectMapper.writeValueAsString(b);
                PrintWriter writer = resp.getWriter();
                writer.print(s);
                writer.close();
            }
        }
    }
}
