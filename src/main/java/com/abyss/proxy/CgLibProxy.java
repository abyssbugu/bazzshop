package com.abyss.proxy;

import com.abyss.domain.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Abyss on 2018/5/19.
 * description:
 */
public class CgLibProxy implements MethodInterceptor {

    private Object target;

    public CgLibProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        Object invoke = method.invoke(target, objects);
        System.out.println("结束事务");
        return invoke;
    }
}
