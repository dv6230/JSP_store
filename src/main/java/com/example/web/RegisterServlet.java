package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    private com.example.service.UserService userService = new com.example.service.imp.UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username") == null || req.getParameter("password") == null || req.getParameter("email") == null) {
            System.out.println("參數不可為NULL");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code") == null ? "abcd" : req.getParameter("code");

        if (!code.equalsIgnoreCase("abcd")) {
            System.out.println("驗證碼錯誤: " + code);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        } else if (userService.ExistUsername(username)) {
            System.out.println("用戶名已存在: " + username);
            req.setAttribute("msg", "用戶名稱已被使用");
            req.setAttribute("email", email);
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        } else {
            userService.RegisterUser(new com.example.pojo.User(null, username, password, email));
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

    }

}
