package com.hyf.loveincode.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyf.loveincode.bean.T_user;
import com.hyf.loveincode.dao.T_userDao;
import com.hyf.loveincode.service.T_userService;

/**
*
* @author loveincode
* @data Sep 19, 2017 10:46:51 AM
*/
@Service("t_userService")
public class T_userServiceImpl implements T_userService {

    @Resource
    private T_userDao t_userDao ;

    public T_user findUserByUsername(String username) {
        T_user t_user = t_userDao.findUserByUsername(username);
        return t_user;
    }

    public Set<String> findRoles(String username) {
        return t_userDao.findRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return t_userDao.findPermissions(username);
    }
}
