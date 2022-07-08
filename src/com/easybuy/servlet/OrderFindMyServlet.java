package com.easybuy.servlet;

import com.easybuy.entity.*;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findMyOrder")
public class OrderFindMyServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl ();
    private OrderService orderService = new OrderServiceImpl ();
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl ();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt (req.getParameter ("userId"));
        int id = -1;

        List<MyOrder> list = new ArrayList<> ();

        List<Order> allOrder = orderService.findAllOrder ();
        List<Order> myOrder = new ArrayList<> ();

        List<OrderDetail> allDetail = orderDetailService.findAllDetail ();
        List<OrderDetail> myDetail = new ArrayList<> ();

        List<Product> allProduct = productService.findAllProduct ();
        List<Product> myProduct = new ArrayList<> ();

        for (int i = 0; i < allOrder.size (); i++) {
            if (allOrder.get (i).getUserId () == userId) {
                id = allOrder.get (i).getId ();
                myOrder.add (allOrder.get (i));
                for (int j = 0; j < allDetail.size (); j++) {
                    if (allDetail.get (j).getOrderId () == id) {
                        myDetail.add (allDetail.get (j));
                        for (int k = 0; k < allProduct.size (); k++) {
                            if (allProduct.get (k).getId ()==allDetail.get (j).getProductId ()){
                                myProduct.add (allProduct.get (k));
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < myDetail.size (); i++) {
            MyOrder myOrder1 = new MyOrder ();
            myOrder1.setQuantity (myDetail.get (i).getQuantity ());
            int cost = (int)myDetail.get (i).getCost ();
            myOrder1.setCost (cost);
            myOrder1.setProduct (myProduct.get (i));
            list.add (myOrder1);
        }

        req.setAttribute ("List1",list);
        req.getRequestDispatcher ("backend/order/orderDetailList.jsp").forward (req, resp);
    }
}

