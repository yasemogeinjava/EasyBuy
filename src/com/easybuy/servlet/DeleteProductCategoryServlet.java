package com.easybuy.servlet;

import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/deleteProductCategory")
public class DeleteProductCategoryServlet extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id!=null){
            boolean b = productCategoryService.deleteById(Integer.parseInt(id));

            ProductCategory productCategory = new ProductCategory();
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(b);
            PrintWriter writer = resp.getWriter();
            writer.println(s);
            writer.close();
        }
    }
}
