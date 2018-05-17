package com.abyss.dao;

import com.abyss.domain.Product;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Abyss on 2018/5/17.
 * description:
 */
public interface ProductDao {
    List<Product> findAllProduct();

    void release(Connection conn, String cid);

    int count();

    List<Product> queryProductsByPageNum(int startIndex, int size);

}
