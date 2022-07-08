package com.easybuy.servlet;

import com.easybuy.entity.Product;
import com.easybuy.entity.ProductCategory;
import com.easybuy.service.ProductService;
import com.easybuy.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productModify")
public class ProductFindById extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCategory> categories1 = productService.categoryFindByType(1);
        List<ProductCategory> categories2 = productService.categoryFindByType(2);
        List<ProductCategory> categories3 = productService.categoryFindByType(3);
        String id = req.getParameter("id");
        if (id != null) {
            Product product = productService.findById(Integer.parseInt(id));
            req.setAttribute("product",product);
            req.setAttribute("productCategoryLevel1",categories1);
            req.setAttribute("productCategoryLevel2",categories2);
            req.setAttribute("productCategoryLevel3",categories3);

            req.getRequestDispatcher("backend/product/toAddProduct.jsp").forward(req,resp);

        }
    }
}
