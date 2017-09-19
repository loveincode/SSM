package com.hyf.loveincode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hyf.loveincode.bean.Rediscontent;
import com.hyf.loveincode.bean.RediscontentExample;

/**
*
* @author loveincode
* @data Sep 19, 2017 2:10:55 PM
*/
public interface RediscontentMapper {
    int countByExample(RediscontentExample example);

    int deleteByExample(RediscontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rediscontent record);

    int insertSelective(Rediscontent record);

    List<Rediscontent> selectByExample(RediscontentExample example);

    Rediscontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rediscontent record, @Param("example") RediscontentExample example);

    int updateByExample(@Param("record") Rediscontent record, @Param("example") RediscontentExample example);

    int updateByPrimaryKeySelective(Rediscontent record);

    int updateByPrimaryKey(Rediscontent record);
}
