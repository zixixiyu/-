package com.group.lesson.vo;

/**
 * @Author: hwj
 * @Date: 2021/9/11 8:38
 */
public class FrontProductVo {
    private Integer id;
    private String name;
    private Double dailyPrice;
    private Double discountDailyPrice;
    private String parameter;
    private String picUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(Double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public Double getDiscountDailyPrice() {
        return discountDailyPrice;
    }

    public void setDiscountDailyPrice(Double discountDailyPrice) {
        this.discountDailyPrice = discountDailyPrice;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
