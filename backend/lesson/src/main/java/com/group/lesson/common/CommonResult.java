package com.group.lesson.common;

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

