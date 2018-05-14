package com.abyss.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Abyss on 2018/4/25.
 * description:
 */
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");

        int width = 130, height = 39; // 图片宽度和高度
        // 创建用于保存图片信息的缓冲区对象
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 获取画笔
        Graphics g = image.getGraphics();

        // 设置画笔颜色
        g.setColor(new Color(255, 255, 255));
        // 填充背景
        g.fillRect(0, 0, width, height);

        // 重新设置画笔颜色
        g.setColor(new Color(0, 0, 0));
        // 绘制边框
        g.drawRect(0, 0, width - 1, height - 1);

        // 创建随机数对象
        Random r = new Random();

        // 添加干扰线
        for (int i = 0; i < 5; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))); // 重新设置画笔颜色
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width),
                    r.nextInt(height));
        }

        // 生成验证码的数据
        String data = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        int length = data.length();
        //最终的验证码
        String capstr = "";
        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 35));
        // 生成四位组合验证码
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(length);
            String str = data.charAt(index) + "";
            capstr += str;
            // 重新设置画笔颜色
            g.setColor(new Color(r.nextInt(200), r.nextInt(200), r.nextInt(200)));
            // 将字符写入图片
            g.drawString(str, 10 + (i * 28), 30);
        }


        HttpSession session = request.getSession();

        session.setAttribute("checkCode", capstr);

        // 释放资源
        g.dispose();

        // 输出流
        OutputStream ots = response.getOutputStream();
        // 将图片写到输出流
        ImageIO.write(image, "jpg", ots);

        ots.flush();
        ots.close(); // 关闭输出流

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
