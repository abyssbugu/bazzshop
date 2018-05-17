package com.abyss.dao;

import com.abyss.domain.User;

/**
 * Created by Abyss on 2018/5/16.
 * description:
 */
public interface LoginDao {
    User findUserByNameAndPwd(String name, String password);

    boolean insertUser(User user);

    void printSome();
}
