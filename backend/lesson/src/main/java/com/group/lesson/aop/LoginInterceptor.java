package com.group.lesson.aop;

import com.alibaba.fastjson.JSON;
import com.group.lesson.common.CommonResult;
import com.group.lesson.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/9 9:11
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ManagerService managerService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<String> asList = Arrays.asList("/v1/user/login", "/v1/user/registry", "/v1/user/distinct","/v1/user/logout","/v1/manager/login");

        String uri = request.getRequestURI();
        //1.设置放行路径
        if(asList.contains(uri)){
            return true;
        }

        List<String> asList1 = Arrays.asList(
                "/v1/user/getAllUser",
                "/v1/user/getUserNum",
                "/v1/product/getNum",
                "/v1/product/getPageProduct",
                "/v1/product/shanxiajia",
                "/v1/product/insertProduct");
        if(asList1.contains(uri)){
            String mToken = request.getHeader("m-token");
            if (mToken==null){
                response.setContentType("application/json; charset=utf-8");
                CommonResult<String> fail = CommonResult.failNotManager();
                response.getWriter().print(JSON.toJSONString(fail));
                return false;
            }
            String username = redisTemplate.opsForValue().get(mToken);
            //查询是否是管理员
            boolean exist = managerService.exist(username);
            if (!exist){
                response.setContentType("application/json; charset=utf-8");
                CommonResult<String> fail = CommonResult.failNotManager();
                response.getWriter().print(JSON.toJSONString(fail));
                return false;
            }

            return true;
        }

        //2.拿到请求头里面的token（如果是第一次登录，那么是没有请求头的）
        String token = request.getHeader("u-token");
        System.out.println("TOKEN:"+token);
        if(token==null){
            response.setContentType("application/json; charset=utf-8");

            //2.1 拦截请求并返回信息给前台 （前台后置拦截器就是根据这里面返回的json数据，来判读并跳转到登录界面）
            CommonResult<String> fail = CommonResult.failToLogin();
            response.getWriter().print(JSON.toJSONString(fail));
            return false;
        }

        //3、如果有token，那么就根据这个token从redis查询登录用户信息，如果redis里面还没过期，那么就正常放行，没有就进行拦截，并返回信息，叫他重新登录
        String tokenUser = redisTemplate.opsForValue().get(token);
        if(tokenUser==null){
            response.setContentType("application/json; charset=utf-8");
            CommonResult<String> fail = CommonResult.failToLogin();
            response.getWriter().print(JSON.toJSONString(fail));
            return false;
        }

        //4.如果没有过期，那么就重新将token和登录用户信息存到redis
        redisTemplate.opsForValue().set(token, tokenUser, 60*30);


        return true;

    }
}
