package com.hyf.loveincode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hyf.loveincode.bean.Person;
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

    @RequestMapping("/showPerson")
    @ResponseBody
    //http://localhost:8080/ssm/personController/showPerson
    public String showPersons(Model model){
        List<Person> persons = personService.loadPersons();
        model.addAttribute("persons", persons);
        return persons.toString();
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
