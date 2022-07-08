package com.easybuy.servlet;

import com.easybuy.entity.User;
import com.easybuy.entity.UserPage;
import com.easybuy.service.UserManageService;
import com.easybuy.service.impl.UserManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/userManageFindById")
public class UserManageFindByIdServlet extends HttpServlet {
    private UserManageService userManageService = new UserManageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println(id);
        if (id!=null){
            User user = userManageService.findById(Integer.parseInt(id));
            req.setAttribute("user",user);
            req.getRequestDispatcher("backend/user/toUpdateUser.jsp").forward(req,resp);
        }
    }
}
