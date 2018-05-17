package com.abyss.dao.impl;

import com.abyss.dao.UserDao;

/**
 * Created by Abyss on 2018/5/16.
 * description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("持久层用户的保存");
    }
}
