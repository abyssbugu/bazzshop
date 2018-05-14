package com.abyss.web; /**
 * Created by Abyss on 2018/5/3.
 * description:
 */

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyServletRequestListener implements ServletContextListener,
        HttpSessionListener ,ServletRequestListener {
    // Public constructor is required by servlet spec
    public MyServletRequestListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
//        Timer timer = new Timer(
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println(new Date().toLocaleString());
//            }
//        }, 0, 1000);
        //初始化在线人数
        sce.getServletContext().setAttribute("onlineNum", 0);

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineNum = (Integer) servletContext.getAttribute("onlineNum");
        servletContext.setAttribute("onlineNum", ++onlineNum);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineNum = (Integer) servletContext.getAttribute("onlineNum");
        servletContext.setAttribute("onlineNum", --onlineNum);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }
}
