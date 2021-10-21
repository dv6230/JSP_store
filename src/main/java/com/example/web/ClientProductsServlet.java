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
import java.util.List;

import static com.example.pojo.Page.PAGE_SIZE;
import static com.example.util.WebUtils.parserInt;

@WebServlet(name = "ClientProductsServlet", value = "/client/productsServlet")
public class ClientProductsServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImp();

    void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parserInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parserInt(request.getParameter("pageSize"), PAGE_SIZE);
        Page<Product> productPage = productService.page(pageNo, pageSize);
        request.setAttribute("page", productPage);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
