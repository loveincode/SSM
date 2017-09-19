package com.hyf.loveincode.service;

import java.util.List;

import com.hyf.loveincode.bean.Rediscontent;
import com.hyf.loveincode.bean.RediscontentExample;
import com.hyf.loveincode.util.PageEntity;

/**
 *
 * @author loveincode
 * @data Sep 19, 2017 2:08:29 PM
 */
public interface RediscontentService {
	List<Rediscontent> selectByExample(RediscontentExample example);

	Rediscontent selectByPrimaryKey(Integer id);

	PageEntity<Rediscontent> selectByPage(Integer pageNum, Integer pageSize);
}
