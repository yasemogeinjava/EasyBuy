package com.easybuy.servlet;

import com.easybuy.service.impl.AddressServiceImpl;
import com.easybuy.entity.Address;
import com.easybuy.entity.User;
import com.easybuy.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/settlement2")
public class SettlementTwoServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User loginUser = (User)httpSession.getAttribute("loginUser");
        int userId = loginUser.getId();
//        Address address = addressService.findAddressListById(userId);
         List<Address> adderssList = addressService.findAddressListById(userId);
        req.setAttribute("userAddressList", adderssList);
        req.getRequestDispatcher("pre/settlement/settlement2.jsp").forward(req,resp);
    }
}
