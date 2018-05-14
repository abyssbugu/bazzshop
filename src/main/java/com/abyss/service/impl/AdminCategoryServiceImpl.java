package com.abyss.service.impl;

import com.abyss.dao.CategoryDao;
import com.abyss.dao.ProductDao;
import com.abyss.domain.Category;
import com.abyss.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
public class AdminCategoryServiceImpl {
    CategoryDao dao = new CategoryDao();

    public void addCategory(Category category) {
        dao.insertCategory(category);
    }

    public List<Category> findALlCategory() {
        return dao.queryAllCategory();
    }

    public Category findCategoryById(String cid) {
        return dao.findCategoryById(cid);
    }

    public void updateCategory(Category cate) {
        dao.updateCategoryById(cate);
    }

    public void deleteCategoryById(String cid) {
        ProductDao productDao = new ProductDao();
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //解绑外键
            productDao.release(conn, cid);
            //删除分类列表
            dao.deleteCategoryById(conn, cid);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    //异常回滚
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    //关闭连接
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
