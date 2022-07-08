package com.easybuy.servlet;

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

@WebServlet("/ProductDeleteById")
public class ProductDeleteByIdServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            //根据得到的id删除
            boolean b = productService.deleteById(Integer.parseInt(id));
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(b);
            PrintWriter writer = resp.getWriter();
            writer.print(s);
            writer.close();
        }
    }
}
