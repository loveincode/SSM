package com.hyf.loveincode.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyf.loveincode.bean.T_user;
import com.hyf.loveincode.service.T_userService;

/**
*
* @author loveincode
* @data Sep 19, 2017 10:54:13 AM
*/
@Controller
@RequestMapping("/")
public class T_userController {
    @Resource
    private T_userService t_userService ;
    @RequestMapping("/loginAdmin")
    public String login(T_user user, Model model){
    	
    	System.out.println(user.getUserName() + user.getPassword());
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword()) ;
        
        try {
            subject.login(token);
            
            return "admin" ;
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
//            e.printStackTrace();
            model.addAttribute("error","用户名或密码错误") ;
            return "../../login" ;
        }
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/student")
    public String student(){
        return "admin" ;
    }
    @RequestMapping("/teacher")
    public String teacher(){
        return "admin" ;
    }
}
