package com.abyss.service;

import com.abyss.domain.User;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
public interface LoginService {
     User login(String username, String password);

     boolean register(User user);
}
