package com.group.lesson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: hwj
 * @Date: 2021/9/9 14:08
 */
@TableName("product")
public class Product {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("categoryId")
    private Integer categoryId;
    private String name;
    /**
     * 押金
     */
    private Double deposit;
    @TableField("dailyPrice")
    private Double dailyPrice;
    @TableField("discountDailyPrice")
    private Double discountDailyPrice;
    /**
     * 目前库存
     */
    @TableField("currentInventory")
    private Integer currentInventory;
    @TableField("totalInventory")
    private Integer totalInventory;

    private String introduce;
    /**
     * json格式字符串，表示参数
     */
    private String parameter;
    /**
     * 图片地址
     */
    @TableField("picUrl")
    private String picUrl;

    /**
     * 该产品是否下架，1表示上架，0表示下架
     */
    @TableField("isDelete")
    private byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public double getDiscountDailyPrice() {
        return discountDailyPrice;
    }

    public void setDiscountDailyPrice(double discountDailyPrice) {
        this.discountDailyPrice = discountDailyPrice;
    }

    public Integer getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(Integer currentInventory) {
        this.currentInventory = currentInventory;
    }

    public Integer getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Integer totalInventory) {
        this.totalInventory = totalInventory;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
        this.isDelete = isDelete;
    }
}
