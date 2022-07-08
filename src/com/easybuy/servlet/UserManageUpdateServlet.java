package com.easybuy.servlet;

import com.easybuy.entity.User;
import com.easybuy.service.UserManageService;
import com.easybuy.service.impl.UserManageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userManageUpdate")
public class UserManageUpdateServlet extends HttpServlet {
    private UserManageService userManageService = new UserManageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String loginName = req.getParameter("loginName");
        String userName = req.getParameter("userName");
        String identityCode = req.getParameter("identityCode");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");
        String type = req.getParameter("type");
        if (loginName!=null){
            User user = new User();
            user.setLoginName(loginName);
            user.setUserName(userName);
            user.setIdentityCode(identityCode);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setType(Integer.parseInt(type));
            if (id.length() != 0) {
                user.setId(Integer.parseInt(id));
                boolean b = userManageService.updateById(user);
                ObjectMapper objectMapper = new ObjectMapper();
                String s = objectMapper.writeValueAsString(b);
                PrintWriter writer = resp.getWriter();
                writer.print(s);
                writer.close();
            }else {
                user.setPassword(password);
                boolean b = userManageService.addUser(user);
                ObjectMapper objectMapper = new ObjectMapper();
                String s = objectMapper.writeValueAsString(b);
                PrintWriter writer = resp.getWriter();
                writer.print(s);
                writer.close();
            }
        }
    }
}
