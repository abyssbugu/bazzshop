package com.abyss.dao.impl;

import com.abyss.dbassit.DbAssist;
import com.abyss.domain.Account;
import com.abyss.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by Abyss on 2018/5/20.
 * description:
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private DbAssist dbAssist;
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public Account findByid(Long id) {
        Account account = null;
        try {
            account = queryRunner.query("select * from account where id=?", new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        try {
            queryRunner.update(dbAssist.getCurrentConnection(), "update account set name=?,money=? where id =?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
