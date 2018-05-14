package com.abyss.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Abyss on 2018/5/2.
 * description:
 */
public class MyRequest extends HttpServletRequestWrapper {

    //使编码只编一次
    private boolean flag = false;

    private  HttpServletRequest request;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        String method = request.getMethod();
        if ("post".equalsIgnoreCase(method)) {
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return super.getParameterMap();
            }

        } else if ("get".equalsIgnoreCase(method)) {

            //将所有的请求参数获取出来，然后，一个一个地处理乱码
            Map<String, String[]> map = request.getParameterMap();
            if (flag) {
                return map;
            }
            if (map != null) {
                for (Map.Entry<String, String[]> entry : map.entrySet()) {
                    String[] strings = entry.getValue();
                    if (strings != null) {
                        for (int i = 0; i < strings.length; i++) {
                            try {
                                strings[i] = new String(strings[i].getBytes("iso-8859-1"), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                continue;
                            }
                        }
                    }
                }
            }
            flag = true;
            return map;

        } else {

            return super.getParameterMap();
        }
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> map = this.getParameterMap();
        if (map != null) {
            return map.get(name);
        }
        return super.getParameterValues(name);
    }

    @Override
    public String getParameter(String name) {
        String[] values = this.getParameterValues(name);
        if (values != null) {
            return values[0];
        }
        return super.getParameter(name);
    }
}
