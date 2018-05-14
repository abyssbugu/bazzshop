package com.abyss.web;

import com.abyss.domain.Category;
import com.abyss.service.impl.AdminCategoryServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
@WebServlet(name = "UpdateCategoryServlet",urlPatterns = "/updateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category cate = new Category();
        AdminCategoryServiceImpl service = new AdminCategoryServiceImpl();
        try {
            BeanUtils.populate(cate,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        service.updateCategory(cate);
        response.sendRedirect(request.getContextPath()+"/findAllCategory");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
