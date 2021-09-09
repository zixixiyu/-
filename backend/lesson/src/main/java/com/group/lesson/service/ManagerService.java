package com.group.lesson.service;

/**
 * @Author: hwj
 * @Date: 2021/9/9 11:04
 */
public interface ManagerService {
    /**
     * 判断该管理员是否存在
     * @param username
     * @return
     */
    boolean exist(String username);

    /**
     * 管理员的登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);
}
