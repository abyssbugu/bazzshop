package com.abyss.dao;

import com.abyss.domain.Product;
import com.abyss.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
public class ProductDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    QueryRunner run = new QueryRunner();


    public List<Product> findAllProduct() {
        List<Product> list;
        try {
            list = queryRunner.query("select * from product", new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品失败");
        }
        return list;
    }

    public void release(Connection conn, String cid) {
        try {
            run.update(conn, "update product set cid = null where cid=?", cid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("解绑cid外键失败");
        }
    }

    public int count() {
        int i;
        try {
            i = queryRunner.query("select count(*) from product", new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询产品总数失败");
        }
        return i;

    }

    public List<Product> queryProductsByPageNum(int startIndex, int size) {
        List<Product> list;
        try {
            list = queryRunner.query("select * from product limit ?,?", new BeanListHandler<>(Product.class), startIndex, size);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("分页查询产品失败");
        }
        return list;
    }

    private void printDevPoint() {
        System.out.println("商品中指定撤销的操作");
    }
    private void printDevInit() {
        System.out.println("发展合并后的提交");
    }
    private void printDevPoint2() {
        System.out.println("这是我进行中的功能.....");
    }
}
