package com.group.lesson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group.lesson.common.CommonResult;
import com.group.lesson.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hwj
 * @Date: 2021/9/9 14:38
 */
@RestController
@RequestMapping("/v1/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult<String> managerLogin(
            @RequestBody String jsonString
    ){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        String token = managerService.login(username, password);

        if (token==null){
            return CommonResult.fail(null,"登录失败");
        }

        return CommonResult.success(token);

    }

}
