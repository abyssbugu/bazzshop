package com.abyss.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Abyss on 2018/5/2.
 * description:
 */
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        MyRequest myRequest = new MyRequest(request);
        chain.doFilter(myRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
