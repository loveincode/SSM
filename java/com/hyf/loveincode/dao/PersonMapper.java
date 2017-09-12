package com.hyf.loveincode.dao;

import java.util.List;

import com.hyf.loveincode.bean.Person;

/**
*
* @author loveincode
* @data Sep 12, 2017 12:15:17 PM
*/
public interface PersonMapper {
    /**
     * 插入一条记录
     * @param person
     */
    void insert(Person person);
    
    /**
     * 查询所有
     * @return
     */
    List<Person> queryAll();
}
