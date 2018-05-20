package com.abyss.dao;

import com.abyss.domain.Account;

/**
 * Created by Abyss on 2018/5/20.
 * description:
 */
public interface AccountDao {
    Account findByid(Long id);

    void update(Account account);
}
