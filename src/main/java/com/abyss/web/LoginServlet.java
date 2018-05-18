package com.abyss.web;

import com.abyss.domain.User;
import com.abyss.service.LoginService;
import com.abyss.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Abyss on 2018/4/20.
 * description:
 */
public class LoginServlet extends HttpServlet {


//    @Autowired
//    private LoginService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isSave = request.getParameter("isSave");
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        String checkCode2 = request.getParameter("checkcode");
        if (checkCode.equalsIgnoreCase(checkCode2)) {
            System.out.println(isSave+"我不太好6");
            LoginService service = new LoginServiceImpl();
            User user = service.login(username, password);
            request.setAttribute("username", username);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userInfo", user);
                //保存Cookie
                if (isSave != null) {
                    Cookie cookie1 = new Cookie("username", username);
                    cookie1.setMaxAge(7 * 3600);
                    response.addCookie(cookie1);
                    Cookie cookie2 = new Cookie("password", password);
                    cookie2.setMaxAge(7 * 3600);
                    response.addCookie(cookie2);
                    Cookie cookie3 = new Cookie("isSave", isSave);
                    cookie3.setMaxAge(7 * 3600);
                    response.addCookie(cookie3);
                } else {
                    //清除Cookie
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            String name = cookie.getName();
                            if ("username".equals(name) || "password".equals(name) || "isSave".equals(name)) {
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                            }
                        }
                    }
                }
                //登录成功页面
//                request.getRequestDispatcher("/loginSuccess.html").forward(request, response);
                //跳转主页
                response.sendRedirect(request.getContextPath());
            } else {
                request.setAttribute("msg", "账号或密码输入错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "验证码输入错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
