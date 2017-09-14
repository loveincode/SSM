package com.hyf.loveincode.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyf.loveincode.bean.Person;
import com.hyf.loveincode.bean.ResultVO;
import com.hyf.loveincode.service.IPersonService;

/**
 *
 * @author loveincode
 * @data Sep 12, 2017 12:16:37 PM
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	private IPersonService personService;

	public IPersonService getPersonService() {
		return personService;
	}

	@Autowired
	public void setPersonService(IPersonService personService) {
		this.personService = personService;
	}

	// 查询 /id get方式
	// http://localhost:8080/ssm/person/1
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody String show(@PathVariable Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		ResultVO resultVO = new ResultVO();
		Person person = new Person();
		person = personService.findById(id);
		if (person != null) {
			resultVO.setSuccess(true);
			resultVO.setData(person);
			resultVO.setMessage("查询成功");
		} else {
			resultVO.setMessage("查询失败，没找到id=" + id + "的Person");
		}
		return resultVO.toString();
	}

	// 新增 POST方式
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String add(@ModelAttribute("person") Person person, HttpServletRequest request,
			HttpServletResponse response) {
		ResultVO resultVO = new ResultVO();
		System.out.println(person.toString());
		if (person.getName() != null) {
			personService.add(person);
			resultVO.setSuccess(true);
			resultVO.setMessage("插入成功");
		} else {
			resultVO.setMessage("name为空，插入失败");
		}
		return resultVO.toString();
	}

	// 更新 /id PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@PathVariable Integer id, @ModelAttribute("person") Person person, HttpServletRequest request,
			HttpServletResponse response) {
		ResultVO resultVO = new ResultVO();
		Person oldperson = personService.findById(id);
		if (oldperson != null) {
			if (person.getName() != null) {
				person.setId(oldperson.getId());
				System.out.println(oldperson.toString());
				personService.update(person);
				resultVO.setMessage("更新成功");
			} else {
				resultVO.setMessage("更新失败，name为空");
			}
		} else {
			resultVO.setMessage("更新失败，不存在 id = " + id + "的Person");
		}
		return resultVO.toString();
	}

	// 删除 /id DELETE方式
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delete(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
		ResultVO resultVO = new ResultVO();
		Person person = new Person();
		person = personService.findById(id);
		if (person != null) {
			resultVO.setSuccess(true);
			personService.delete(id);
			resultVO.setMessage("删除成功");
		} else {
			resultVO.setMessage("删除失败，不存在id = " + id + "的Person");
		}
		return resultVO.toString();
	}

	@RequestMapping("/test")
	@ResponseBody
	// http://localhost:8080/ssm/personController/test
	public String test() {
		List<Person> persons = personService.loadPersons();
		System.out.println(persons.toString());

		Person person = new Person();
		person.setAge(29);
		person.setName("new");
		// 增加
		personService.add(person);
		persons = personService.loadPersons();
		System.out.println("新增后:");
		System.out.println(persons.toString());
		// 查找
		person = personService.findByName("new");
		System.out.println("查找:" + person.toString());

		// 修改
		person.setName("update");
		personService.update(person);
		persons = personService.loadPersons();
		System.out.println("修改后:");
		System.out.println(persons.toString());

		// 删除
		personService.delete(person.getId());
		persons = personService.loadPersons();
		System.out.println("删除后:");
		System.out.println(persons.toString());

		Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

		return gson.toJson(persons);
	}

	@RequestMapping("/showPerson")
	@ResponseBody
	// http://localhost:8080/ssm/person/showPerson
	public String showPersons(Model model) {
		List<Person> persons = personService.loadPersons();
		model.addAttribute("persons", persons);
		Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(persons);
	}

	@RequestMapping("/showPersonspage")
	// http://localhost:8080/ssm/person/showPersonspage
	public ModelAndView showPersonspage() {
		List<Person> persons = personService.loadPersons();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("persons", persons);
		System.out.println(persons.toString());
		modelAndView.setViewName("showperson");
		return modelAndView;
	}

}
