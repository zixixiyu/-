package com.group.lesson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group.lesson.common.CommonResult;
import com.group.lesson.common.RegexUtil;
import com.group.lesson.entity.User;
import com.group.lesson.mapper.UserMapper;
import com.group.lesson.service.UserService;
import com.group.lesson.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
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

    @RequestMapping(value ="/getUserNum",method = RequestMethod.GET)
    public CommonResult<Integer> getUserNum(){
        return CommonResult.success(userService.getUserNum());
    }


    @RequestMapping(value = "/distinct",method = RequestMethod.GET)
    public CommonResult<Boolean> distinctUsername(
            @RequestParam("username")String username
    ){
        if (!StringUtils.hasText(username)){
            return CommonResult.fail(Boolean.FALSE,"用户名不可以为空");
        }
        if (!userService.distinctUsername(username)){
            return CommonResult.fail(Boolean.FALSE,"用户名已经被注册了");
        }else {
            return CommonResult.success(Boolean.TRUE);
        }
    }
    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    public CommonResult<Boolean> registry(
            @RequestBody String jsonString
    ){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String mobile = jsonObject.getString("mobile");
        String email = jsonObject.getString("email");
        if (!StringUtils.hasText(username)||!StringUtils.hasText(password)||!StringUtils.hasText(mobile)||!StringUtils.hasText(email)){
            return CommonResult.fail(Boolean.FALSE,"参数不可以为空");
        }
        if (!userService.distinctUsername(username)){
            return CommonResult.fail(Boolean.FALSE,"用户名已经被注册了");
        }
        if (!RegexUtil.isMobile(mobile)) {
            return CommonResult.fail(Boolean.FALSE,"手机号格式不正确");
        }
        if (!RegexUtil.isEmail(email)){
            return CommonResult.fail(Boolean.FALSE,"邮箱格式不正确");
        }
        User user = new User();
        user.setRegistryDate(new Date());
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);
        Boolean registry = userService.registry(user);
        if (registry){
            return CommonResult.success(Boolean.TRUE);
        }else {
            return CommonResult.fail(Boolean.FALSE,"注册失败");
        }
    }
    @RequestMapping("/login")
    public CommonResult<String> login(
            @RequestBody String jsonString
    ){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        if (!StringUtils.hasText(username)||!StringUtils.hasText(username)){
            return CommonResult.fail("账号密码不可以为空","账号密码不可以为空");
        }
        String token = userService.login(username,password);

        if (token == null){
            return CommonResult.fail("账号密码不正确","账号密码不正确");
        }
        return CommonResult.success(token);


    }
    @RequestMapping("/logout")
    public CommonResult<Boolean> logout(){
        String token = httpServletRequest.getHeader("u-token");
        if (token!=null){
            Boolean delete = redisTemplate.delete(token);
            return CommonResult.success(Boolean.TRUE);
        }
        return CommonResult.success(Boolean.TRUE);
    }

}
