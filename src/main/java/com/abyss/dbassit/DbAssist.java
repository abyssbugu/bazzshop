package com.abyss.dbassit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Abyss on 2018/5/20.
 * description:
 */
@Component("dbAssist")
public class DbAssist {
    @Autowired
    private DataSource dataSource;

    public Connection getCurrentConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    public void releaseConnection() {
        DataSourceUtils.releaseConnection();
    }
}
