package com.abyss.dbassit;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Abyss on 2018/5/20.
 * description:
 */
public class DataSourceUtils {

    //线程本地变量，用于把Connection和当前线程绑定
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /**
     *从数据源中获取connection
     * */
    public static Connection getConnection(DataSource dataSource) {
        Connection connection = tl.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                tl.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 释放连接
     */
    public static void releaseConnection() {
        Connection connection = tl.get();
        if (connection != null) {
            try {
                connection.close();
                tl.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
