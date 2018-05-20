package com.abyss.service;

/**
 * Created by Abyss on 2018/5/20.
 * description:
 */
public interface AccountService {
    void transfer(Long fromId, Long toId, Double money);
}
