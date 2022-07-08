package com.easybuy.servlet;

import com.easybuy.dao.UserDao;
import com.easybuy.dao.impl.UserDaoImpl;
import com.easybuy.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String loginName = req.getParameter("loginName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String identityCode_ = req.getParameter("identityCode");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        User byName = userDao.findByName(loginName);
        if (byName == null) {
            User user = new User();
            user.setLoginName(loginName);
            user.setUserName(userName);
            user.setPassword(password);
            user.setSex(Integer.parseInt(sex));
            user.setIdentityCode(identityCode_);
            user.setEmail(email);
            user.setMobile(mobile);
            boolean b = userDao.addUser(user);

            if (b == true) {
                ObjectMapper objectMapper = new ObjectMapper();
                String s = objectMapper.writeValueAsString(user);
                PrintWriter writer = resp.getWriter();
                writer.println(s);
                writer.close();
            }
        }else {
            System.out.println("注册失败，用户名已存在");
        }
    }
}
