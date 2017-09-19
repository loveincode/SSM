package com.hyf.loveincode.dao;

import java.util.Set;

import com.hyf.loveincode.bean.T_user;

/**
*
* @author loveincode
* @data Sep 19, 2017 10:47:28 AM
*/
public interface T_userDao {
    T_user findUserByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}