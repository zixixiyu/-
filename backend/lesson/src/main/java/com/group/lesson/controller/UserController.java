package com.group.lesson.controller;

import com.group.lesson.common.CommonResult;
import com.group.lesson.entity.User;
import com.group.lesson.mapper.UserMapper;
import com.group.lesson.service.UserService;
import com.group.lesson.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 2 * @Author: hwj
 * 3 * @Date: 2021/9/6 19:11
 * 4
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public CommonResult<List<UserVo>> get(
            @RequestParam("pageNum") int pageNum
    ){
        if (pageNum<=0){
            return CommonResult.fail(new ArrayList<UserVo>(),"查询参数不正确");
        }
        List<UserVo> allUser = userService.getAllUser(pageNum);

        return CommonResult.success(allUser);
    }

    @RequestMapping(value ="getUserNum",method = RequestMethod.GET)
    public CommonResult<Integer> getUserNum(){

        return CommonResult.success(userService.getUserNum());

    }


}
