package com.easybuy.servlet;

import com.easybuy.entity.*;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/addOrderDetail")
public class OrderDetailAddServlet2 extends HttpServlet {
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        //获得商品id、数量、价格
        String productId = req.getParameter("entityId");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Product product = productService.findById(Integer.parseInt(productId));
        double price = product.getPrice ();
        //计算总价
        BigDecimal a = new BigDecimal(Double.toString(price));
        BigDecimal b = new BigDecimal(Double.toString(quantity));
        double cost = a.multiply(b).intValue();
        List<Cart> carts = (List<Cart>) httpSession.getAttribute("productCar");
        List<Cart> cartList = new ArrayList<> ();
        int j = 0;
        boolean xx =false;
        if (carts!=null){
            for (int i = 0; i < carts.size (); i++) {
                cartList.add (carts.get (i));
            }
            for (int i = 0; i < carts.size (); i++) {
                if (Integer.parseInt(productId) != carts.get(i).getProduct().getId()){
                    j++;
                    if (j==carts.size ()){
                        xx=true;
                    }
                }
            }
        }
        if (carts!=null) {
            for (int i = 0; i <carts.size() ; i++) {
                if (Integer.parseInt(productId) == carts.get(i).getProduct().getId()) {
                    Cart cart = ((List<Cart>) httpSession.getAttribute("productCar")).get(i);
                    int quantity1 = quantity+cartList.get(i).getQuantity();
                    BigDecimal c = new BigDecimal(Double.toString(quantity1));
                    double cost1 = a.multiply(c).intValue();
                    cart.setQuantity(quantity1);
                    cart.setCost(cost1);
                    cartList.add(cart);
                    boolean addCar = true;
                    ObjectMapper objectMapper = new ObjectMapper();
                    String s = objectMapper.writeValueAsString(addCar);
                    PrintWriter writer = resp.getWriter();
                    writer.print(s);
                    writer.close();
                    break;
                }else if (xx==true){
                    Cart cart = new Cart();
                    cart.setProduct(product);
                    cart.setQuantity(quantity);
                    cart.setCost(cost);
                    carts.add(cart);
//                    httpSession.setAttribute("productCar",orderDetails);
//            OrderDetail car = (OrderDetail) httpSession.getAttribute("productCar");
                    boolean addCar = true;
                    ObjectMapper objectMapper = new ObjectMapper();
                    String s = objectMapper.writeValueAsString(addCar);
                    PrintWriter writer = resp.getWriter();
                    writer.print(s);
                    writer.close();
                    break;
                }
            }
        }else {
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setQuantity(quantity);
            cart.setCost(cost);
            cartList.add(cart);
            httpSession.setAttribute("productCar",cartList);
//            OrderDetail car = (OrderDetail) httpSession.getAttribute("productCar");
            boolean addCar = true;
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(addCar);
            PrintWriter writer = resp.getWriter();
            writer.print(s);
            writer.close();
        }
        double totalPrice = 0;
        List<Cart> productCar = (List<Cart>) httpSession.getAttribute ("productCar");
        for (int i = 0; i < productCar.size(); i++) {
            totalPrice = totalPrice+productCar.get(i).getCost();
        }
        httpSession.setAttribute("totalPrice",totalPrice);
    }
}
