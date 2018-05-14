package com.abyss.web;

import com.abyss.domain.PageBean;
import com.abyss.domain.Product;
import com.abyss.service.impl.ProductServiceImpl;
import com.abyss.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
@WebServlet(name = "FindAllProductsServlet", urlPatterns = {"/findAllProducts"})
public class FindAllProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        ProductService service = new ProductServiceImpl();
//        List<Product> list = service.findAll();
        PageBean pageBean= service.findProductsByPageNum(pageNum);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("product_list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
