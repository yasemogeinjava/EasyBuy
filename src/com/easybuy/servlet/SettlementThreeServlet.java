package com.easybuy.servlet;

import com.easybuy.entity.*;
import com.easybuy.service.AddressService;
import com.easybuy.service.OrderDetailService;
import com.easybuy.service.OrderService;
import com.easybuy.service.impl.AddressServiceImpl;
import com.easybuy.service.impl.OrderDetailServiceImpl;
import com.easybuy.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/settlement3")
public class SettlementThreeServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    private OrderService orderService = new OrderServiceImpl ();
    private OrderDetailService orderDetailService = new OrderDetailServiceImpl ();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        List<Cart> carts = (List<Cart>) httpSession.getAttribute("productCar");
        User loginUser = (User)httpSession.getAttribute("loginUser");
        Object totalPrice1 = httpSession.getAttribute("totalPrice");
        double totalPrice = Double.valueOf (totalPrice1.toString());
        int addressId = Integer.parseInt(req.getParameter("addressId"));
        Address addressFindById = addressService.findById(addressId);
        String newAddress = req.getParameter("newAddress");
        String newRemark = req.getParameter("newRemark");
        Order orderFindByUserId = orderService.findByUserId(loginUser.getId());
        String address1 = null;
        if (addressFindById == null) {
            address1 = newAddress;
        }else {
            address1 = addressFindById.getAddress();
        }
        if (addressId == -1) {
            Address address = new Address();
            address.setAddress(newAddress);
            address.setUserId(loginUser.getId());
            address.setRemark(newRemark);
            addressService.addAddress(address);
//            req.setAttribute("userAddress",newAddress);
        }else if (orderFindByUserId == null) {
            Order order = new Order();
            order.setUserId(loginUser.getId());
            order.setLoginName(loginUser.getLoginName());
            order.setUserAddress(address1);
            order.setCreateTime(new Date());
            order.setCost(totalPrice);
            order.setSerialNumber("51718726C1274CC59504AB4E6FD64BA0");
            orderService.addOrder(order);
        }else if (orderFindByUserId != null) {
            Order order = new Order();
            order.setUserId(loginUser.getId());
            order.setLoginName(loginUser.getLoginName());
            order.setUserAddress(address1);
            order.setCreateTime(new Date());
            order.setCost(totalPrice);
            order.setSerialNumber("51718726C1274CC59504AB4E6FD64BA0");
            orderService.addOrder(order);
        }
            for (int i = 0; i <carts.size() ; i++) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderFindByUserId.getId());
                orderDetail.setProductId(carts.get(i).getProduct().getId());
                orderDetail.setQuantity(carts.get(i).getQuantity());
                orderDetail.setCost(carts.get(i).getCost());
                orderDetailService.addOrderDetail(orderDetail);
            }

        req.setAttribute("serialNumber","51718726C1274CC59504AB4E6FD64BA0");
        req.setAttribute("cost",totalPrice);
        if (addressFindById == null) {
            req.setAttribute("userAddress",newAddress);
        }else {
            req.setAttribute("userAddress",addressFindById.getAddress());
        }
        httpSession.removeAttribute("productCar");
        httpSession.removeAttribute("totalPrice");

        req.getRequestDispatcher("pre/settlement/settlement3.jsp").forward(req,resp);

    }
}
