package com.abyss.service.impl;

import com.abyss.dao.AccountDao;
import com.abyss.domain.Account;
import com.abyss.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Abyss on 2018/5/20.
 * description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(Long fromId, Long toId, Double money) {
        Account a1 = accountDao.findByid(1L);
        Account a2 = accountDao.findByid(2L);
        a1.setMoney(a1.getMoney() - 100);
        accountDao.update(a1);
        a2.setMoney(a2.getMoney() + 100);
        accountDao.update(a2);
    }
}
