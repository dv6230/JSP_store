package com.example.web;

import com.example.pojo.Page;
import com.example.pojo.Product;
import com.example.service.ProductService;
import com.example.service.imp.ProductServiceImp;
import com.example.util.WebUtils;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static com.example.pojo.Page.PAGE_SIZE;
import static com.example.util.WebUtils.parserInt;

@WebServlet(name = "productServlet", value = "/manage/productServlet")
public class ProductServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImp();

    void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = WebUtils.CopyParamToBean(request.getParameterMap(), new Product());
        productService.addProduct(product);
//        request.getRequestDispatcher("/manage/productServlet?action=list").forward(request,response);
        Page<Product> page = productService.page(0, PAGE_SIZE);
        response.sendRedirect(request.getContextPath() + "/manage/productServlet?action=page&pageNo=" + page.getPageCount());
    }

    void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String request_id = request.getParameter("id").toString();
        int id = parserInt(request.getParameter("id").toString(), 0);
        productService.deleteProduct(id);
        String pageNo = "";
        if (request.getParameter("pageNo") != null) {
            pageNo = "&pageNo="+request.getParameter("pageNo");
        }
        response.sendRedirect(request.getContextPath() + "/manage/productServlet?action=page"+pageNo);
    }

    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = WebUtils.CopyParamToBean(request.getParameterMap(), new Product());
        productService.updateProduct(product);
        response.sendRedirect(request.getContextPath() + "/manage/productServlet?action=page");
    }

    void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productService.queryProductById(id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.queryProduct();
        request.setAttribute("products", productList);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parserInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parserInt(request.getParameter("pageSize"), PAGE_SIZE);
        Page<Product> productPage = productService.page(pageNo, pageSize);
        request.setAttribute("page", productPage);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

}
