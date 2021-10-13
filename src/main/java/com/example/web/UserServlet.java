package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.imp.UserServiceImp;
import com.example.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private UserService userService = userService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImp();
        User loginUser = userService.Login(new User(null, username, password, null));
        if (loginUser == null) {
            req.setAttribute("msg", "帳號或密碼錯誤");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username") == null || req.getParameter("password") == null || req.getParameter("email") == null) {
            System.out.println("參數不可為NULL");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }

        User user = (User) WebUtils.CopyParamToBean(req.getParameterMap(),new User());

        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String code = "abcd";

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
            userService.RegisterUser(new User(null, username, password, email));
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
