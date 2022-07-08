package com.easybuy.servlet;

import com.easybuy.entity.News;
import com.easybuy.entity.Page;
import com.easybuy.service.NewsService;
import com.easybuy.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsFindById")
public class NewsFindByIdServlet extends HttpServlet {
    private NewsService newsService = new NewsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println(id);
        if (id!=null){
            News news = newsService.findById(Integer.parseInt(id));
            Page page = new Page();
            req.setAttribute("news",news);
            req.setAttribute("page",page);
            req.getRequestDispatcher("backend/news/newsDetail.jsp").forward(req,resp);
        }
    }
}
