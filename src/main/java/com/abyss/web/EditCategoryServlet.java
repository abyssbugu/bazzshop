package com.abyss.web;

import com.abyss.domain.Category;
import com.abyss.service.impl.AdminCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
@WebServlet(name = "EditCategoryServlet", urlPatterns = "/editCategoryServlet")
public class EditCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        AdminCategoryServiceImpl service = new AdminCategoryServiceImpl();
        Category category = service.findCategoryById(cid);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/admin/category/edit.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
