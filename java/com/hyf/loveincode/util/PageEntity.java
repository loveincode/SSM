package com.hyf.loveincode.util;

import java.io.Serializable;
import java.util.List;

/**
*
* @author loveincode
* @data Sep 19, 2017 2:07:24 PM
*/
public class PageEntity<T> implements Serializable {
    private List<T> list;// 分页后的数据
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

