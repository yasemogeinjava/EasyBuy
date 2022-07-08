package com.easybuy.servlet;

import com.easybuy.entity.News;
import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.NewsService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.NewsServiceImpl;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl ();
    private NewsService newsService = new NewsServiceImpl ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> categoryList = productService.findAllProductCategory ();
        req.setAttribute ("categoryList",categoryList);  // product_category中所有的数据
        List<Product> pList = productService.findAllProduct ();
        req.setAttribute ("pList",pList);
        List<ProductCategory> categoryList1 = new ArrayList<> ();
        List<ProductCategory> categoryList2 = new ArrayList<> ();
        List<ProductCategory> categoryList3 = new ArrayList<> ();
        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==1) {
                categoryList1.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList1",categoryList1);// product_category中一级标题的数据

        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==2) {
                categoryList2.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList2",categoryList2);// product_category中二级标题的数据

        for (int i = 0; i < categoryList.size (); i++) {
            if (categoryList.get (i).getType ()==3) {
                categoryList3.add (categoryList.get (i));
            }
        }
        req.setAttribute ("categoryList3",categoryList3);// product_category中三级标题的数据

        List<News> fiveNews = newsService.findFiveNews ();
        req.setAttribute ("fiveNews",fiveNews);
        req.getRequestDispatcher ("pre/index.jsp").forward (req,resp);
    }
}
