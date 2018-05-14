package com.abyss.dao;

import com.abyss.domain.User;
import com.abyss.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by Abyss on 2018/4/20.
 * description:
 */
public class LoginDao {
    public User findUserByNameAndPwd(String name, String password) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        User user;
        try {
            user = queryRunner.query("select * from user where username=? and password=?", new BeanHandler<>(User.class), name, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询异常");
        }
        return user;
    }

    public boolean insertUser(User user) {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        int update;
        try {
            update = queryRunner.update("insert into user values(?,?,?,?,?,?,?,?,?)", null, user.getUsername(), user.getPassword(),
                    user.getAge(), user.getSex(), user.getEmail(), user.getHobby(), user.getAddress(), user.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("用户注册sql异常");
        }
        return update > 0;



    }

    public void printSome() {
        System.out.println("打印点什么");
    }
}
