package com.abyss.dao;

import com.abyss.domain.Category;
import com.abyss.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
public class CategoryDao {

    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    public void insertCategory(Category category) {
        try {
            queryRunner.update("insert into category values(?,?)", category.getCid(), category.getCname());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加分类失败");
        }
    }

    public List<Category> queryAllCategory() {
        List<Category> query;
        try {
            query = queryRunner.query("select * from category", new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有分类失败");
        }
        return query;
    }

    public Category findCategoryById(String cid) {
        Category query = null;
        try {
            query = queryRunner.query("select * from category where cid=?", new BeanHandler<>(Category.class), cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public void updateCategoryById(Category cate) {
        try {
            queryRunner.update("update category set cname=? where cid=?", cate.getCname(), cate.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategoryById(Connection conn, String cid) {
        QueryRunner runner = new QueryRunner();
        try {
            runner.update(conn, "delete from category where cid=?", cid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败");
        }
    }

    private void printTest() {
        System.out.println("主分支");
    }
    private void printMaster() {
        System.out.println("主分支二次提交");
    }
    private void printMaster3() {
        System.out.println("主分支三次提交");
    }
    private void printDevPoint() {
        System.out.println("分类中指定撤销的操作");
    }

}
