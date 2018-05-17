package com.abyss.dao.impl;

import com.abyss.dao.UserDao;

/**
 * Created by Abyss on 2018/5/16.
 * description:
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("构造方法调用");
    }

    public void init() {
        System.out.println("init被调用");
    }

    @Override
    public void save() {
        System.out.println("持久层用户的保存");
    }

    public void destroy() {
        System.out.println("destroy调用");
    }
}
