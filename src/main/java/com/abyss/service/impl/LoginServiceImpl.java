package com.abyss.service.impl;

import com.abyss.dao.LoginDao;
import com.abyss.dao.impl.LoginDaoImpl;
import com.abyss.domain.User;
import com.abyss.service.LoginService;

/**
 * Created by Abyss on 2018/4/20.
 * description:
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public User login(String username, String password) {
        LoginDao dao = new LoginDaoImpl();
        return dao.findUserByNameAndPwd(username, password);
    }

    @Override
    public boolean register(User user) {
        LoginDao dao = new LoginDaoImpl();
        return dao.insertUser(user);
    }
}
