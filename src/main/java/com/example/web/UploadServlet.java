package com.example.web;

import com.example.pojo.Page;
import com.example.pojo.Product;
import com.example.service.ProductService;
import com.example.service.imp.ProductServiceImp;
import com.example.util.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.example.pojo.Page.PAGE_SIZE;

@WebServlet(name = "UploadServlet", value = "/manage/uploadServlet")
public class UploadServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID uuid = (UUID) request.getSession().getAttribute("uuid");
        if (uuid != null) {
            request.getSession().setAttribute("uuid", null);
            Product product = new Product();

            if (ServletFileUpload.isMultipartContent(request)) {
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload servletFileUpload = new ServletFileUpload((org.apache.commons.fileupload.FileItemFactory) fileItemFactory);
                List<FileItem> list = null;
                try {
                    list = servletFileUpload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }

                product.setName(request.getParameter("name"));

                UUID imgUid = UUID.randomUUID();
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {

//                        System.out.println(fileItem.getFieldName());
//                        System.out.println(fileItem.getString("UTF-8"));
//                        System.out.println("");

                        switch (fileItem.getFieldName()) {
                            case "name":
                                product.setName(fileItem.getString("UTF-8"));
                                break;
                            case "note":
                                product.setNote(fileItem.getString("UTF-8"));
                                break;
                            case "price":
                                product.setPrice(WebUtils.parserInt(fileItem.getString("UTF-8"), 0));
                                break;
                            case "stock":
                                product.setStock(WebUtils.parserInt(fileItem.getString("UTF-8"), 0));
                                break;
                            case "sales":
                                product.setSales(WebUtils.parserInt(fileItem.getString("UTF-8"), 0));
                                break;
                        }
                    } else {
                        String file = fileItem.getName();
                        String fileName = fileItem.getName().substring(file.indexOf("."), file.length());
                        try {
                            fileItem.write(new File("D:\\Java\\JSP_store\\src\\main\\webapp\\img_file\\" + imgUid.toString() + fileName));
                            product.setimgPath(imgUid.toString() + fileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            productService.addProduct(product);
            Page<Product> page = productService.page(0, PAGE_SIZE);
            response.sendRedirect(request.getContextPath() + "/manage/productServlet?action=page&pageNo=" + page.getPageCount());
        } else {
            response.sendRedirect(request.getContextPath() + "/manage/productServlet?action=page");
        }
    }

}
