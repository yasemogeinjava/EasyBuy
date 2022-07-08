package com.easybuy.servlet;

import com.easybuy.entity.OrderDetail;
import com.easybuy.service.OrderDetailService;
import com.easybuy.service.impl.OrderDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderDetail")
public class OrderDetailFindAllServlet extends HttpServlet {
    private OrderDetailService orderDetailService=new OrderDetailServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDetail> orderDetailList=orderDetailService.findAllDetail();
        req.setAttribute("list1",orderDetailList);
        req.getRequestDispatcher("backend/order/orderDetailList.jsp").forward(req,resp);
    }
}
