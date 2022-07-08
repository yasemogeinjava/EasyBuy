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
@WebServlet("/userManageFindPage")
public class UserManageFindPageServlet extends HttpServlet {
    private UserManageService userManageService = new UserManageServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得页面数据
        String page = req.getParameter("curPage");
        //定义页面内容长度
        int pageSize = 10;
        //判断是第几页
        int curPage = page == null ? 1 : Integer.parseInt (page);

        //定义url
        String url=req.getRequestURI();

        //得到数据的总条数和总页数
        int total = userManageService.countNumber();
        if (curPage<1){
            curPage = 0;
        }
        int totalPage = total/pageSize==0?total/pageSize:(total/pageSize+1);
        if (curPage>totalPage){
            curPage = totalPage;
        }

        List<User> user = userManageService.findUserPage(curPage,pageSize);
        req.setAttribute("page",new UserPage(user,curPage,totalPage,url));
        req.setAttribute("userList",user);

        req.getRequestDispatcher("backend/user/userList.jsp").forward(req,resp);
    }
}
