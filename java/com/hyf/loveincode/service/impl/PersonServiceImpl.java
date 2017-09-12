package com.hyf.loveincode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyf.loveincode.bean.Person;
import com.hyf.loveincode.dao.PersonMapper;
import com.hyf.loveincode.service.IPersonService;

/**
*
* @author loveincode
* @data Sep 12, 2017 12:16:13 PM
*/
@Service("personService")
public class PersonServiceImpl implements IPersonService {
    
    private PersonMapper personMapper;

    public PersonMapper getPersonMapper() {
        return personMapper;
    }
    @Autowired
    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }
    
	public List<Person> loadPersons() {
		 return personMapper.queryAll();
	}
	@Override
	public void add(Person person) {
		personMapper.insert(person);
	}
	@Override
	public void delete(Integer id) {
		personMapper.delete(id);
	}
	@Override
	public void update(Person person) {
		personMapper.update(person);
	}
	@Override
	public Person findByName(String name) {
		return personMapper.findByName(name);
	}

}
