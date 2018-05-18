package com.abyss.service.impl;

import com.abyss.dao.LoginDao;
import com.abyss.dao.impl.LoginDaoImpl;
import com.abyss.domain.User;
import com.abyss.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Abyss on 2018/4/20.
 * description:
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao dao;

    @Override
    public User login(String username, String password) {
        return dao.findUserByNameAndPwd(username, password);
    }

    @Override
    public boolean register(User user) {
        return dao.insertUser(user);
    }
}
