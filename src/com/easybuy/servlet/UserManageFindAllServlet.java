package com.easybuy.servlet;

import com.easybuy.entity.Page;
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
import java.util.List;
@WebServlet("/userManageFindAll")
public class UserManageFindAllServlet extends HttpServlet {
    private UserManageService userManageService = new UserManageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> all = userManageService.findAll ();
        req.setAttribute ("userList",all);

//        userManageService.findAll();
//        String page = req.getParameter("page");
//        if (page ==null){
//            page = "1";
//        }
//        int pageSize = 10;
//        int curPage = page == null ? 1 : Integer.parseInt (page);
//        String url=req.getRequestURI();
//        int total = userManageService.countNumber();
//        int totalPage = total/pageSize==0?total/pageSize:(total/pageSize+1);
//
//        if (curPage<1){
//            curPage = 1;
//        }else if (curPage>totalPage){
//            curPage = totalPage-1;
//        }
//
//        List<User> user = userManageService.findUserPage(curPage,pageSize);
//        req.setAttribute("page",new UserPage(user,curPage,totalPage,url));
//        req.setAttribute("userList",user);
//
        req.getRequestDispatcher("backend/user/userList.jsp").forward(req,resp);
    }
}

