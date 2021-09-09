package com.group.lesson.service;

import com.group.lesson.entity.User;
import com.group.lesson.vo.UserVo;

import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/8 13:17
 */
public interface UserService {

    /**
     * 分页获取用户
     * @param pageNum
     * @return
     */
    List<UserVo> getAllUser(Integer pageNum);

    /**
     * 获取用户总数量
     * @return
     */
    Integer getUserNum();

    /**
     * 查看该用户名是否已经存在了
     * @param username
     * @return
     */
    Boolean distinctUsername(String username);

    /**
     * 注册用户
     * @param user
     * @return
     */
    Boolean registry(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);
}
