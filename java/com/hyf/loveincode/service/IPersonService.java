package com.hyf.loveincode.service;

import java.util.List;
import java.util.Map;

import com.hyf.loveincode.bean.Person;
import com.hyf.loveincode.util.Page;

/**
*
* @author loveincode
* @data Sep 12, 2017 12:15:53 PM
*/
public interface IPersonService {

    /**
     * 加载全部的person
     * @return
     */
	public List<Person> queryAll();
	
	public void add(Person person);
	
	public void delete(Integer id);
	
	public void update(Person person);
	
	public Person findByName(String name);
		
	public Person findById(Integer id);
	
	public Page<Person> listByPage(int pageNo, int limit) ;
	
	public List<Person> listByParams(Map<String,Object> params);
	
}
