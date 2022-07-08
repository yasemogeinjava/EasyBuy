package com.easybuy.servlet;

import com.easybuy.entity.User;
import com.easybuy.service.UserManageService;
import com.easybuy.service.impl.UserManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/userManageAdd")
public class UserManageAddServlet extends HttpServlet {
    private UserManageService userManageService = new UserManageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String loginName = req.getParameter("loginName");
        String userName = req.getParameter("userName");
        String identityCode = req.getParameter("identityCode");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String type = req.getParameter("type");
            User user = new User();
            if (id != null) {
                user.setId(Integer.parseInt(id));
                user.setLoginName(loginName);
                user.setUserName(userName);
                user.setIdentityCode(identityCode);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setType(Integer.parseInt(type));
                boolean b = userManageService.addUser(user);
                req.getRequestDispatcher("backend/user/userList.jsp").forward(req, resp);
            }

        }
}
