package com.easybuy.servlet;

import com.easybuy.entity.Cart;
import com.easybuy.entity.OrderDetail;
import com.easybuy.entity.Product;
import com.easybuy.entity.User;
import com.easybuy.service.DetailService;
import com.easybuy.service.ProductService;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.DetailSerciceImpl;
import com.easybuy.service.impl.ProductServiceImpl;
import com.easybuy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/settlement1")
public class SettlementOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pre/settlement/settlement1.jsp").forward(req,resp);

    }
}
