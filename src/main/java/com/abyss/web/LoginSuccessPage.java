package com.abyss.web;

import com.abyss.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Abyss on 2018/4/21.
 * description:
 */
public class LoginSuccessPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("Content-type", "text/html;charset=UTF-8");//告知浏览器编码方式;
        response.setContentType ("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        String username =  request.getParameter("username");
        User user = (User) request.getSession().getAttribute("userInfo");
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\'UTF-8\'>");
        printWriter.println("<title>Insert title here</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h2> 姓名: "+username+",loginSuccess</h2>");
        printWriter.println("<h2>性别: "+user.getSex()+"</h2>");
        printWriter.println("<h2> 年龄: "+user.getAge()+"</h2>");
        printWriter.println("<h2> 爱好: "+user.getHobby()+"</h2>");
        printWriter.println("<h2> 邮箱: "+user.getEmail()+"</h2>");
        printWriter.println("<h2> 地址: "+user.getAddress()+"</h2>");
        printWriter.println("<h2> 描述: "+user.getDescription()+"</h2>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
