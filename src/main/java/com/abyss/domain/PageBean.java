package com.abyss.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Abyss on 2018/5/6.
 * description:
 */
@Component("pageBean")
@Scope("prototype")
public class PageBean {
    //总数
    int count;
    //大小
    int size;
    //尾页
    int end;
    //页数
    int pageNum;
    //数据
    List<?> data;
    //分页栏
    int[] bar;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int[] getBar() {
        int start;
        int stop;
        //少于10页
        if (end < 10) {
            start = 1;
            stop = end;
        } else {
            start = pageNum - 5;
            stop = pageNum + 4;
            //设置边界
            if (pageNum - 5 <= 0) {
                start = 1;
                stop = 10;
            }
            if (pageNum + 4 >= end) {
                start = end - 9;
                stop = end;
            }
        }
        bar = new int[stop - start + 1];
        for (int i = start, index = 0; i <= stop; i++) {
            bar[index++] = i;
        }
        return bar;
    }

    public void setBar(int[] bar) {
        this.bar = bar;
    }
}
