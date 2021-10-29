package com.example.web;

import com.example.dao.ProductDao;
import com.example.dao.imp.ProductDaoImp;
import com.example.pojo.Cart;
import com.example.pojo.Product;
import com.example.pojo.User;
import com.example.service.OrderService;
import com.example.service.imp.OrderServiceImp;
import com.example.util.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/orderServlet")
public class OrderServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImp();

    void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
        } else if (cart == null) {
            response.sendRedirect(request.getContextPath());
        } else {
            String orderId = orderService.createOrder(cart, user.getId());

//            request.setAttribute("orderId", orderId); // 如果畫面沒有跳轉，則可以用request，導向其他頁面　request 會被刪除
//            request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
            request.getSession().setAttribute("orderId", orderId);
            response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }

}
