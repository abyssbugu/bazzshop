package com.abyss.web;

import com.abyss.dao.UserDao;
import com.abyss.domain.PageBean;
import com.abyss.domain.Product;
import com.abyss.service.impl.ProductServiceImpl;
import com.abyss.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

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


    @Autowired
    private ProductService productService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService service = (ProductService) context.getBean("productService");
//        ProductService service = new ProductServiceImpl();
        System.out.println("开始10");
        PageBean pageBean = productService.findProductsByPageNum(pageNum);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("product_list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
