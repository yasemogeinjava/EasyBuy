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


@WebServlet("/NewsFindAll")
public class NewsFindAllServlet extends HttpServlet {
   private NewsService newsService = new NewsServiceImpl();
//    Page page =new Page();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<News> queryNewsList = newsService.findAllNews();

        String page = req.getParameter("page");
        if (page ==null){
            page = "1";
        }

        int pageSize = 5;
        int curPage = page == null ? 1 : Integer.parseInt (page);
        String url=req.getRequestURI();
        int total = newsService.countNumber();
        int totalPage = total/pageSize==0?total/pageSize:(total/pageSize+1);

        if (curPage<1){
            curPage = 1;
        }else if (curPage>totalPage){
            curPage = totalPage-1;
        }

        List<News> news = newsService.findNewsPage(curPage,pageSize);
        req.setAttribute("pager",new Page(news,curPage,totalPage,url));
        req.setAttribute("newsList",news);

        req.getRequestDispatcher("backend/news/newsList.jsp").forward(req,resp);
//        req.getRequestDispatcher("common/backend/leftBar.jsp").forward(req,resp);
    }


}
