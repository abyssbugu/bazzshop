package com.abyss.dao.impl;

import com.abyss.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Abyss on 2018/5/16.
 * description:
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Value("大锤")
    private String name;

    public UserDaoImpl() {
        System.out.println("构造方法调用");
    }

    public void init() {
        System.out.println("init被调用");
    }

    @Override
    public void save() {
        System.out.println("持久层用户的保存" + name);
    }

    public void destroy() {
        System.out.println("destroy调用");
    }
}
