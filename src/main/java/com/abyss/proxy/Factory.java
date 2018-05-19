package com.abyss.proxy;

import com.abyss.dao.UserDao;
import com.abyss.dao.impl.UserDaoImpl;

/**
 * Created by Abyss on 2018/5/17.
 * description:
 */
public class Factory {
    public  UserDao  createUserDao() {
        return new UserDaoImpl();
    }
}
