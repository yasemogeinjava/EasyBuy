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
import java.util.List;

@WebServlet("/userManageDelete")
public class UserManageDeleteServlet extends HttpServlet {
    private UserManageService userManageService = new UserManageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.取页面传过来的值
        String id = req.getParameter("id");
        if(id!=null) {
            //2.调用service
            boolean b = userManageService.deleteById(Integer.parseInt(id));
//            //3.传值jsp页面??
//            List<User> allUser = userManageService.findAll();
//            req.setAttribute("list",allUser);
//            //4.跳转页面
//            req.getRequestDispatcher("backend/user/userList.jsp").forward(req,resp);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(b);
            PrintWriter writer = resp.getWriter();
            writer.print(s);
            writer.close();
        }
    }
}
