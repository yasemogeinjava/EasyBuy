package com.easybuy.servlet;

import com.easybuy.dao.UserDao;
import com.easybuy.dao.impl.UserDaoImpl;
import com.easybuy.entity.User;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        User user = userService.getByNameAndPwd(loginName,password);
        if (user != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("loginUser",user);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(user);
            PrintWriter writer = resp.getWriter();
            writer.println(s);
            writer.close();
        }

    }
}
