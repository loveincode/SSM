package com.hyf.loveincode.service;

import java.util.List;

import com.hyf.loveincode.bean.Person;

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
	public List<Person> loadPersons();
}
