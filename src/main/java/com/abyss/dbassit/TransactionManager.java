package com.abyss.dbassit;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by Abyss on 2018/5/20.
 * description:事务管理切面类
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private DbAssist dbAssist;

    @Before("execution(* com.abyss.service.impl.*.*(..))")
    public void beginTransaction() {
        try {
            dbAssist.getCurrentConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @AfterReturning("execution(* com.abyss.service.impl.*.*(..))")
    public void commitTransaction() {
        try {
            dbAssist.getCurrentConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Around("execution(* com.abyss.service.impl.*.*(..))")
    public void rollbackTransaction() {
        try {
            dbAssist.getCurrentConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @After("execution(* com.abyss.service.impl.*.*(..))")
    public void releaseConnection() {
        dbAssist.releaseConnection();
    }
}
