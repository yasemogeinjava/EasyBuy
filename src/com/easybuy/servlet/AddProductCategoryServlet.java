package com.easybuy.servlet;

import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductCategoryService;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductCategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addProductCategory")
public class AddProductCategoryServlet extends HttpServlet {

    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String type = req.getParameter("type");

        String productCategoryLevel1 = req.getParameter("productCategoryLevel1");
        int p1 = Integer.parseInt(productCategoryLevel1);
        String productCategoryLevel2 = req.getParameter("productCategoryLevel2");
        int p2 = Integer.parseInt(productCategoryLevel2);



        List<ProductCategory> allProductCategory = productCategoryService.findAllProductCategory();
        req.setAttribute("productCategory",allProductCategory);


        int parenId = Math.max(p1,p2);
        ProductCategory productCategory = new ProductCategory();
        if (name!=null){
            productCategory.setName(name);
            productCategory.setType(Integer.parseInt(type));
            productCategory.setParentId(parenId);
            boolean b = productCategoryService.addProductCategory(productCategory);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(b);
            PrintWriter writer = resp.getWriter();
            writer.println(s);
            writer.close();
        }

    }


}
