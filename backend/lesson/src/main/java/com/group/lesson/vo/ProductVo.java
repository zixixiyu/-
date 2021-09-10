package com.group.lesson.vo;

/**
 * @Author: hwj
 * @Date: 2021/9/10 8:53
 */
public class ProductVo {
    private String categoryName;
    private String productName;
    private Double deposit;
    private Double dailyPrice;
    private Double discountDailyPrice;
    private Integer currentInventory;
    private Integer totalInventory;
    private String introduce;
    private String parameter;
    private Byte isDelete;

    public ProductVo() {
    }

    public ProductVo(String categoryName, String productName, Double deposit, Double dailyPrice, Double discountDailyPrice, Integer currentInventory, Integer totalInventory, String introduce, String parameter, Byte isDelete) {
        this.categoryName = categoryName;
        this.productName = productName;
        this.deposit = deposit;
        this.dailyPrice = dailyPrice;
        this.discountDailyPrice = discountDailyPrice;
        this.currentInventory = currentInventory;
        this.totalInventory = totalInventory;
        this.introduce = introduce;
        this.parameter = parameter;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "categoryName='" + categoryName + '\'' +
                ", productName='" + productName + '\'' +
                ", deposit=" + deposit +
                ", dailyPrice=" + dailyPrice +
                ", discountDailyPrice=" + discountDailyPrice +
                ", currentInventory=" + currentInventory +
                ", totalInventory=" + totalInventory +
                ", introduce='" + introduce + '\'' +
                ", parameter='" + parameter + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
