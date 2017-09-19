package com.hyf.loveincode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hyf.loveincode.bean.Rediscontent;
import com.hyf.loveincode.bean.RediscontentExample;
import com.hyf.loveincode.dao.RediscontentMapper;
import com.hyf.loveincode.service.RediscontentService;
import com.hyf.loveincode.util.PageEntity;

/**
*
* @author loveincode
* @data Sep 19, 2017 2:10:17 PM
*/
@Service
public class RediscontentServiceImpl implements RediscontentService {

    @Autowired
    private RediscontentMapper rediscontentMapper;


    public List<Rediscontent> selectByExample(RediscontentExample example) {
        return rediscontentMapper.selectByExample(example);
    }

    public Rediscontent selectByPrimaryKey(Integer id) {
        return rediscontentMapper.selectByPrimaryKey(id);
    }

    public PageEntity<Rediscontent> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //因为是demo，所以这里默认没有查询条件。
        List<Rediscontent> rediscontents = rediscontentMapper.selectByExample(new RediscontentExample());
        PageEntity<Rediscontent> rediscontentPageEntity = new PageEntity<Rediscontent>();
        rediscontentPageEntity.setList(rediscontents);
        int size = rediscontentMapper.selectByExample(new RediscontentExample()).size();
        rediscontentPageEntity.setCount(size);
        return rediscontentPageEntity;
    }


}