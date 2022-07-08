package com.easybuy.servlet;

import com.easybuy.entity.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CartDelete")
public class CartDeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        List<Cart> carts = (List<Cart>) httpSession.getAttribute("productCar");
        int productId = Integer.parseInt (req.getParameter ("entityId"));

        if (carts != null) {
            for (int i = 0; i < carts.size(); i++) {
                if (productId == carts.get(i).getProduct().getId()) {
                    Cart cart = ((List<Cart>) httpSession.getAttribute("productCar")).get(i);
                    carts.remove(cart);
                    boolean deleteCart = true;
                    ObjectMapper objectMapper = new ObjectMapper();
                    String s = objectMapper.writeValueAsString(deleteCart);
                    PrintWriter writer = resp.getWriter();
                    writer.print(s);
                    writer.close();
                }
            }
        }
        double totalPrice = 0;
        List<Cart> productCar = (List<Cart>) httpSession.getAttribute ("productCar");
        for (int i = 0; i < productCar.size(); i++) {
            totalPrice = totalPrice+productCar.get(i).getCost();
        }
        httpSession.setAttribute("totalPrice",totalPrice);
    }
}
