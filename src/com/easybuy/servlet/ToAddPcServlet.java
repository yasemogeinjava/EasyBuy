package com.easybuy.servlet;

import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toAddPc")
public class ToAddPcServlet extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> allProductCategory = productCategoryService.findAllProductCategory();

        req.setAttribute("productCategoryList1",allProductCategory);
        req.getRequestDispatcher("backend/productCategory/toAddProductCategory.jsp").forward(req,resp);


    }
}
