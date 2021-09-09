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
}
