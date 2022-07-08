package com.easybuy.servlet;

import com.easybuy.entity.Order;
import com.easybuy.entity.OrderDetail;
import com.easybuy.entity.Product;
import com.easybuy.service.OrderDetailService;
import com.easybuy.service.OrderService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.OrderDetailServiceImpl;
import com.easybuy.service.impl.OrderServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderList")
public class OrderFindAllServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService=new OrderServiceImpl();
    private OrderDetailService orderDetailService=new OrderDetailServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList=orderService.findAllOrder();
        List<OrderDetail> orderDetailList=orderDetailService.findAllDetail();
        List<Product> allProduct = productService.findAllProduct();
        req.setAttribute("list",orderList);
        req.setAttribute("list1",orderDetailList);
        req.setAttribute("allProduct",allProduct);
        req.getRequestDispatcher("backend/order/orderList.jsp").forward(req,resp);
    }
}
