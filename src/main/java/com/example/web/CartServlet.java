package com.example.web;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.pojo.Product;
import com.example.service.ProductService;
import com.example.service.imp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/cartServlet")
public class CartServlet extends BaseServlet {

    ProductService productService = new ProductServiceImp();

    void addItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.valueOf(request.getParameter("productId"));
        Product product = productService.queryProductById(id);
        CartItem cartItem = new CartItem(product.getId(),product.getName(),1,product.getPrice(),product.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath());
    }
}
