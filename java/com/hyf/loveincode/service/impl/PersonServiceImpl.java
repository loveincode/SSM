package com.hyf.loveincode.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyf.loveincode.bean.Person;
import com.hyf.loveincode.dao.PersonMapper;
import com.hyf.loveincode.service.IPersonService;
import com.hyf.loveincode.util.Page;

/**
 *
 * @author loveincode
 * @data Sep 12, 2017 12:16:13 PM
 */
@Service("personService")
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonMapper personMapper;

	public List<Person> queryAll() {
		return personMapper.queryAll();
	}

	public void add(Person person) {
		personMapper.insert(person);
	}

	public void delete(Integer id) {
		personMapper.delete(id);
	}

	public void update(Person person) {
		personMapper.update(person);
	}

	public Person findByName(String name) {
		return personMapper.findByName(name);
	}

	public Person findById(Integer id) {
		return personMapper.findById(id);
	}

	public Page<Person> listByPage(int pageNo, int pageNum) {
		Page<Person> page = new Page<Person>(pageNo, pageNum);

		int offset = page.getOffsets();
		RowBounds rowBound = new RowBounds(offset, pageNum);
		System.err.println(rowBound.getOffset() + " rowbound " + rowBound.getLimit());

		List<Person> users = personMapper.listByPage(rowBound);
		page.setRows(users);
		int total = personMapper.countAll();
		page.setTotal(total);
		if (offset >= page.getTotal()) {
			page.setPageNo(page.getTotalPages());
		}
		return page;
	}

	public List<Person> listByParams(Map<String, Object> params) {
		List<Person> users = personMapper.listByParams(params);
		return users;
	}

}
