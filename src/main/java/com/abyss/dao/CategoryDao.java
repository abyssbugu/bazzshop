package com.abyss.dao;

import com.abyss.domain.Category;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Abyss on 2018/5/17.
 * description:
 */
public interface CategoryDao {
    void insertCategory(Category category);

    List<Category> queryAllCategory();

    Category findCategoryById(String cid);

    void updateCategoryById(Category cate);

    void deleteCategoryById(Connection conn, String cid);

    Double save();

    void error();


}
