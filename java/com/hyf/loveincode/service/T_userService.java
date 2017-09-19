package com.hyf.loveincode.service;

import java.util.Set;

import com.hyf.loveincode.bean.T_user;

/**
*
* @author loveincode
* @data Sep 19, 2017 10:46:09 AM
*/
public interface T_userService {
    /**
     * Shiro的登录验证，通过用户名查询用户信息
     * @param username
     * @return
     */
    public T_user findUserByUsername(String username) ;

    /**
     * 根据账号查找角色名称
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) ;

    /**
     * 根据账号查找权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) ;
}
