package com.abyss.service;

import com.abyss.domain.PageBean;
import com.abyss.domain.Product;

import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
public interface ProductService {
    List<Product> findAll();

    PageBean findProductsByPageNum(int pageNum);
}
