package com.group.lesson.common;

import java.awt.*;

/**
 * 2 * @Author: hwj
 * 3 * @Date: 2021/9/6 19:12
 * 4
 */
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public static <T> CommonResult<T> success(T data){
        CommonResult<T> common = new CommonResult<>();
        common.setCode(200);
        common.setData(data);
        common.setMessage("操作成功");
        return common;
    }
    public static <T> CommonResult<T> fail(T data,String message){
        CommonResult<T> common = new CommonResult<>();
        common.setMessage(message);
        common.setCode(400);
        common.setData(data);
        return common;

    }
    public static  CommonResult<String> failToLogin(){
        CommonResult<String> common = new CommonResult<>();
        common.setMessage("登录失败");
        common.setCode(499);
        common.setData("");
        return common;
    }
    public static CommonResult<String> failNotManager(){
        CommonResult<String> common = new CommonResult<>();
        common.setMessage("非管理员无法登录");
        common.setCode(498);
        common.setData("");
        return common;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

