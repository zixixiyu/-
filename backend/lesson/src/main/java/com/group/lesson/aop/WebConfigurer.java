package com.group.lesson.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/9 9:25
 */
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> asList = Arrays.asList("/v1/user/login", "/v1/user/registry", "/v1/user/distinct");
        registry.addInterceptor(loginInterceptor).excludePathPatterns(asList);
    }
}
