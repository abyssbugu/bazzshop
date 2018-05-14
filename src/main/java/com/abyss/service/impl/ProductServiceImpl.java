package com.abyss.service.impl;

import com.abyss.dao.ProductDao;
import com.abyss.domain.PageBean;
import com.abyss.domain.Product;
import com.abyss.service.ProductService;

import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
public class ProductServiceImpl implements ProductService {
    ProductDao dao = new ProductDao();

    @Override
    public List<Product> findAll() {
        return dao.findAllProduct();
    }

    @Override
    public PageBean findProductsByPageNum(int pageNum) {
        //总数量
        int count = dao.count();
        //每页的大小
        int size = 10;
        //尾页
        int end = count % size == 0 ? (count / size) : (count / size) + 1;
        //根据起点和大小查询商品
        List<Product> list = dao.queryProductsByPageNum((pageNum - 1) * size, size);
        //封装数据
        PageBean bean = new PageBean();

        bean.setCount(count);
        bean.setEnd(end);
        bean.setSize(size);
        bean.setPageNum(pageNum);
        bean.setData(list);

        return bean;
    }
}
