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
import java.util.List;
@WebServlet("/findNewsByPage")
public class NewsFindByPageServlet extends HttpServlet {
    private NewsService newsService = new  NewsServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得页面数据
        String page = req.getParameter("curPage");
        //定义页面内容长度
        int pageSize = 5;
        //判断是第几页
        int curPage = page == null ? 1 : Integer.parseInt (page);

        //定义url
        String url=req.getRequestURI();

        //得到数据的总条数和总页数
        int total = newsService.countNumber();
        if (curPage<1){
            curPage = 0;
        }
        int totalPage = total/pageSize==0?total/pageSize:(total/pageSize+1);
       if (curPage>totalPage){
            curPage = totalPage;
        }

        List<News> news = newsService.findNewsPage(curPage,pageSize);
        req.setAttribute("pager",new Page(news,curPage,totalPage,url));
        req.setAttribute("newsList",news);

        req.getRequestDispatcher("backend/news/newsList.jsp").forward(req,resp);
    }
}

