package com.group.lesson.controller;

import com.group.lesson.common.CommonResult;
import com.group.lesson.entity.User;
import com.group.lesson.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2 * @Author: hwj
 * 3 * @Date: 2021/9/6 19:11
 * 4
 */
@Controller
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUser")
    @ResponseBody
    public CommonResult<User> get(){

        return CommonResult.success(userMapper.selectById(2));
    }

}
