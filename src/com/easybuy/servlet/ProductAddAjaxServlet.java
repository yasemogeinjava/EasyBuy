package com.easybuy.servlet;

import com.easybuy.entity.Data;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductServiceImpl;
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

@WebServlet("/addProductAjax")
public class ProductAddAjaxServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl ();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> allProductCategory = productService.findAllProductCategory ();
        List<ProductCategory> categoryList1 = new ArrayList<> ();
        List<ProductCategory> categoryList2 = new ArrayList<> ();
        List<ProductCategory> categoryList3 = new ArrayList<> ();

        for (int i = 0; i < allProductCategory.size (); i++) {
            if (allProductCategory.get (i).getType ()==2) {
                categoryList2.add (allProductCategory.get (i));
            }
        }


        for (int i = 0; i < allProductCategory.size (); i++) {
            if (allProductCategory.get (i).getType ()==1) {
                categoryList1.add (allProductCategory.get (i));
            }
        }


        for (int i = 0; i < allProductCategory.size (); i++) {
            if (allProductCategory.get (i).getType ()==3) {
                categoryList3.add (allProductCategory.get (i));
            }
        }

        Data data = new Data (categoryList1,categoryList2,categoryList3);
        ObjectMapper objectMapper = new ObjectMapper ();
        String s = objectMapper.writeValueAsString (data);
        PrintWriter pw =resp.getWriter ();
        pw.println (s);
        pw.close ();
    }
}
