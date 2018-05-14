package com.abyss.web;

import com.abyss.domain.User;
import com.abyss.service.LoginService;
import com.abyss.service.impl.LoginServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Abyss on 2018/4/21.
 * description:
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String securitycode = request.getParameter("securitycode");
        String checkCode = (String) session.getAttribute("checkCode");

        //验证成功
        if (checkCode.equals(securitycode)) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            String[] hobbies = request.getParameterValues("hobby");
            StringBuilder builder = new StringBuilder();
            if (hobbies != null) {
                for (int i = 0; i < hobbies.length; i++) {
                    builder.append(hobbies[i]).append(i == hobbies.length - 1 ? "" : ",");
                }
            }
            try {
                BeanUtils.populate(user, parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            user.setHobby(builder.toString());
            LoginService loginService = new LoginServiceImpl();
            if (loginService.register(user)) {
                request.getRequestDispatcher("/login.html").forward(request, response);
            } else {//失败去登录页面
                response.getWriter().print("注册失败");
            }
        } else {
            response.getWriter().print("security code input error");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
