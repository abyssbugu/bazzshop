package com.abyss.service.impl;

import com.abyss.dao.ProductDao;
import com.abyss.domain.PageBean;
import com.abyss.domain.Product;
import com.abyss.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Abyss on 2018/5/5.
 * description:
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
//    @Autowired
//    private PageBean pageBean;


    @Override
    public List<Product> findAll() {
        return productDao.findAllProduct();
    }

    @Override
    public PageBean findProductsByPageNum(int pageNum) {
        //总数量
        int count = productDao.count();
        //每页的大小
        int size = 10;
        //尾页
        int end = count % size == 0 ? (count / size) : (count / size) + 1;
        //根据起点和大小查询商品
        List<Product> list = productDao.queryProductsByPageNum((pageNum - 1) * size, size);
        //封装数据
        PageBean pageBean = new PageBean();

        pageBean.setCount(count);
        pageBean.setEnd(end);
        pageBean.setSize(size);
        pageBean.setPageNum(pageNum);
        pageBean.setData(list);

        return pageBean;
    }
}
