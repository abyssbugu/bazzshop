package com.abyss.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Abyss on 2018/4/24.
 * description:
 */
public class LoginPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        String isSave = "";
        if (cookies != null) {
            String name;
            for (Cookie cookie : cookies) {
                name = cookie.getName();
                if ("username".equals(name)) {
                    username = cookie.getValue();
                }
                if ("password".equals(name)) {
                    password = cookie.getValue();
                }
                if ("isSave".equals(name)) {
                    isSave="".equals(cookie.getValue())?"":"checked="+cookie.getValue();
                }
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");
        writer.println("<head>");
        writer.println("    <meta charset='UTF-8'>");
        writer.println("    <title>登录页面</title>");
        writer.println("    <style>");
        writer.println("        form {");
        writer.println("            margin:20px auto;");
        writer.println("            width: 300px;");
        writer.println("            background-color: #f5f5f5;");
        writer.println("            text-align: center;");
        writer.println("        }");
        writer.println("        table{");
        writer.println("            padding-top: 20px;");
        writer.println("            border:1px solid #3c365c;");
        writer.println("            width: 300px;");
        writer.println("        }");
        writer.println("        .title{");
        writer.println("            text-align: right;");
        writer.println("        }");
        writer.println("    </style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<form action='login.htm' method='post'>");
        writer.println("    <table>");
        writer.println("        <tr>");
        writer.println("            <td class='title'>用户名:</td>");
        writer.println("            <td>");
        writer.println("                <input type='text' name='username' value='" + username + "'>");
        writer.println("            </td>");
        writer.println("        </tr>");
        writer.println("        <tr>");
        writer.println("            <td class='title'>密码:</td>");
        writer.println("            <td>");
        writer.println("                <input type='password' name='password' value='" + password + "'>");
        writer.println("            </td>");
        writer.println("        </tr>");
        writer.println("        <tr>");
        writer.println("            <td></td>");
        writer.println("            <td style='text-align: right;padding-right: 30px;' ><input type='checkbox' name='isSave'"  + isSave +">记住密码</td>");
        writer.println("        </tr>");
        writer.println("        <tr>");
        writer.println("            <td></td>");
        writer.println("            <td class='title'><input type='submit'></td>");
        writer.println("        </tr>");
        writer.println("    </table>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
