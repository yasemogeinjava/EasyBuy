package com.easybuy.servlet;

import com.easybuy.entity.*;
import com.easybuy.service.DetailService;
import com.easybuy.service.ProductService;
import com.easybuy.service.UserService;
import com.easybuy.service.impl.DetailSerciceImpl;
import com.easybuy.service.impl.ProductServiceImpl;
import com.easybuy.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/orderDetailfindById")
public class OrderDetailfindByIdServlet extends HttpServlet {
    private DetailService detailService = new DetailSerciceImpl();
    private UserService userService = new UserServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("loginUser");
        int userId = user.getId();

        //获取订单
        if (userId!=0){
            int orderId = detailService.orderIdFindByUserId(userId);//根据用户id查找对应的所有订单id
            List<Integer> productId = detailService.productIdFindByorderId(orderId);//根据订单id查找对应的所有商品id
            List<Product> product =  productService.findProductListByIdList(userId,productId);




            //首页导航项
            List<ProductCategory> categoryList = productService.findAllProductCategory ();
            req.setAttribute ("categoryList",categoryList);  // product_category中所有的数据
            List<Product> pList = productService.findAllProduct ();
            req.setAttribute ("pList",pList);
            List<ProductCategory> categoryList1 = new ArrayList<>();
            List<ProductCategory> categoryList2 = new ArrayList<> ();
            List<ProductCategory> categoryList3 = new ArrayList<> ();
            for (int i = 0; i < categoryList.size (); i++) {
                if (categoryList.get (i).getType ()==1) {
                    categoryList1.add (categoryList.get (i));
                }
            }
            int totalPrice = 0;
            for (int i = 0; i < product.size(); i++) {
                totalPrice = (int) (product.get(i).getPrice()*product.get(i).getQuantity()) + totalPrice;
            }

            httpSession.setAttribute("totalPrice",totalPrice);
            httpSession.setAttribute("product",product);
            req.setAttribute ("categoryList1",categoryList1);// product_category中一级标题的数据
            req.setAttribute("orderDetailList",product);
            req.getRequestDispatcher("pre/settlement/toSettlement.jsp").forward(req,resp);

        }
    }
}