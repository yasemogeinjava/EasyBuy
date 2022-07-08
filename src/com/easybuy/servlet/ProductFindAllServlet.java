package com.easybuy.servlet;

import com.easybuy.entity.Pager;
import com.easybuy.entity.Product;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllProduct")
public class ProductFindAllServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        int pagesize=10;
        if(currentPage==null){
            currentPage="1";
        }
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
//        req.setAttribute("productList",products);
//        req.getRequestDispatcher("backend/product/productList.jsp").forward(req,resp);
    }
}
