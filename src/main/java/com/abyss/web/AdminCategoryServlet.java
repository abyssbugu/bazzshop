package com.abyss.web;

import com.abyss.domain.Category;
import com.abyss.service.impl.AdminCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
@WebServlet(name = "AdminCategoryServlet", urlPatterns = "/adminCategoryServlet")
public class AdminCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String cid = UUID.randomUUID().toString().replace("-", "");
        Category category = new Category();
        category.setCid(cid);
        category.setCname(cname);
        AdminCategoryServiceImpl service = new AdminCategoryServiceImpl();
        service.addCategory(category);
        response.sendRedirect(request.getContextPath() + "/findAllCategory");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
