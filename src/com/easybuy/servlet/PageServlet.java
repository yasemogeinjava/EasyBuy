package com.easybuy.servlet;

import com.easybuy.entity.ProductCategory;
import com.easybuy.entity.News;
import com.easybuy.entity.Pager;
import com.easybuy.entity.Product;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.NewsService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.easybuy.service.impl.NewsServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/page")
public class PageServlet extends HttpServlet {
    NewsService newService=new NewsServiceImpl();
    ProductCategoryService categoryService=new ProductCategoryServiceImpl ();
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        Object url = session.getAttribute("url");
        if(url==null){
            url = req.getParameter("url");
        }
        String currentPage = req.getParameter("currentPage");
        int pagesize=10;
        if(currentPage==null){
            currentPage="1";
        }
        if("new".equals(url)){
            int i=newService.count();
            int totalpage=i%pagesize==0?i/pagesize:i/pagesize+1;
            int currentPage1=Integer.parseInt(currentPage);
            if(currentPage1>totalpage){
                currentPage1=totalpage;
            }else if(currentPage1<1){
                currentPage1=1;
            }
            List<News> newList = newService.PageNews(currentPage1, pagesize);
            Pager pager=new Pager(totalpage,"new",currentPage1);
            req.setAttribute("pager",pager);
            req.setAttribute("newsList",newList);
            req.getRequestDispatcher("backend/news/newsList.jsp").forward(req,resp);
        }
        if("Category".equals(url)){
            int i=categoryService.count();
            int totalpage=i%pagesize==0?i/pagesize:i/pagesize+1;
            int currentPage1=Integer.parseInt(currentPage);
            if(currentPage1>totalpage){
                currentPage1=totalpage;
            }else if(currentPage1<1){
                currentPage1=1;
            }
            List<ProductCategory> productCategoryList=categoryService.PageCategory(currentPage1,pagesize);
            List<ProductCategory> productCategoryList1=new ArrayList<>();
            for (int j = 0; j < productCategoryList.size(); j++) {
                ProductCategory category = productCategoryList.get(j);
                String s = categoryService.FindparentNameById(category.getParentId());
                category.setParentName (s);
                productCategoryList1.add(category);
            }
            Pager pager=new Pager(totalpage,"Category",currentPage1);
            req.setAttribute("pager",pager);
            req.setAttribute("productCategoryList",productCategoryList1);
            req.getRequestDispatcher("backend/productCategory/productCategoryList.jsp").forward(req,resp);
        }
        if("product".equals(url)){
            int i=productService.count();
            int totalpage=i%pagesize==0?i/pagesize:i/pagesize+1;
            int currentPage1=Integer.parseInt(currentPage);
            if(currentPage1>totalpage){
                currentPage1=totalpage;
            }else if(currentPage1<1){
                currentPage1=1;
            }
            List<Product> productList = productService.PageCategory(currentPage1, pagesize);
            Pager pager=new Pager(totalpage,"product",currentPage1);
            req.setAttribute("pager",pager);
            req.setAttribute("productList",productList);
            req.getRequestDispatcher("backend/product/productList.jsp").forward(req,resp);
        }
    }
}
