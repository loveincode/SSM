package com.hyf.loveincode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hyf.loveincode.bean.Person;
import com.hyf.loveincode.dao.PersonMapper;
import com.hyf.loveincode.service.IPersonService;

/**
*
* @author loveincode
* @data Sep 12, 2017 12:16:37 PM
*/
@Controller
@RequestMapping("/personController")
public class PersonController {

    private IPersonService personService;
    
    public IPersonService getPersonService() {
        return personService;
    }

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping("/test")
    @ResponseBody
    //http://localhost:8080/ssm/personController/test
    public String test(){
        List<Person> persons = personService.loadPersons();
        System.out.println(persons.toString());
        
        Person person = new Person();
        person.setAge(29);
        person.setName("new");
        //增加
        personService.add(person);
        persons = personService.loadPersons();
        System.out.println("新增后:");
        System.out.println(persons.toString());
        //查找
        person = personService.findByName("new");
        System.out.println("查找:"+person.toString());
        
        //修改
        person.setName("update");
        personService.update(person);
        persons = personService.loadPersons();
        System.out.println("修改后:");
        System.out.println(persons.toString());
        
        //删除
        personService.delete(person.getId());
        persons = personService.loadPersons();
        System.out.println("删除后:");
        System.out.println(persons.toString());
        
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        
		return gson.toJson(persons);
    }

    @RequestMapping("/showPerson")
    @ResponseBody
    //http://localhost:8080/ssm/personController/showPerson
    public String showPersons(Model model){
        List<Person> persons = personService.loadPersons();
        model.addAttribute("persons", persons);
        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(persons);
    }
    
    @RequestMapping("/showPersonspage")
    //http://localhost:8080/ssm/personController/showPersonspage
    public ModelAndView showPersonspage(){
        List<Person> persons = personService.loadPersons();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("persons", persons);
        System.out.println(persons.toString());
        modelAndView.setViewName("showperson");
        return modelAndView;
    }
}
