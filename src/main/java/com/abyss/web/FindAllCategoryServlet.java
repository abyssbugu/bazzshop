package com.abyss.web;

import com.abyss.domain.Category;
import com.abyss.service.impl.AdminCategoryServiceImpl;

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
@WebServlet(name = "FindAllCategoryServlet", urlPatterns = "/findAllCategory")
public class FindAllCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminCategoryServiceImpl service = new AdminCategoryServiceImpl();
        List<Category> list = service.findALlCategory();
        request.setAttribute("clist", list);
        request.getRequestDispatcher("/admin/category/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
