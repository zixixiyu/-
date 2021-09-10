package com.group.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.entity.Category;
import com.group.lesson.entity.Product;
import com.group.lesson.mapper.CategoryMapper;
import com.group.lesson.mapper.ProductMapper;
import com.group.lesson.mapper.ProductVoMapper;
import com.group.lesson.service.ProductService;
import com.group.lesson.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: hwj
 * @Date: 2021/9/10 8:47
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductVoMapper productVoMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Integer getProductNum() {
        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
        return productMapper.selectCount(productQueryWrapper);
    }

    @Override
    public List<ProductVo> getPageProduct(Integer pageNum) {
        List<ProductVo> pageNum1 = productVoMapper.getPageNum((pageNum - 1) * 10);
        return pageNum1;
    }

    @Override
    public boolean shxjia(String productName) {
        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<Product>();
        productQueryWrapper.eq("name",productName);
        List<Product> products = productMapper.selectList(productQueryWrapper);
        if (products.size() != 1){
            return false;
        }
        Product product = products.get(0);
        if (product.getIsDelete()==1){
            product.setIsDelete((byte) 0);
        }else if (product.getIsDelete()==0){
            product.setIsDelete((byte) 1);
        }
        productMapper.updateById(product);
        return true;
    }

    @Override
    public boolean insertProduct(Map<String, String> postInfo, String imgName) {
        String categoryName = postInfo.get("categoryName");
        String chineseName = getChineseName(categoryName);
        if ("".equals(chineseName)){
            return false;
        }
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.eq("name", chineseName);
        List<Category> categories = categoryMapper.selectList(categoryQueryWrapper);
        if (categories.size()!=1){
            return false;
        }
        Integer categoryId = categories.get(0).getId();
        Product product = new Product();
        product.setName(postInfo.get("name"));
        product.setDeposit(Double.parseDouble(postInfo.get("deposit")));
        product.setDailyPrice(Double.parseDouble(postInfo.get("dailyPrice")));
        product.setDiscountDailyPrice(Double.parseDouble(postInfo.get("discountDailyPrice")));
        product.setCurrentInventory(Integer.parseInt(postInfo.get("currentInventory")));
        product.setTotalInventory(Integer.parseInt(postInfo.get("totalInventory")));
        product.setIntroduce(postInfo.get("introduce"));
        product.setParameter(postInfo.get("parameter"));
        product.setPicUrl(imgName);
        product.setIsDelete((byte) 1);
        product.setCategoryId(categoryId);
        productMapper.insert(product);
        return true;

    }

    private String getChineseName(String categoryName){
        String chineseName = "";
        switch (categoryName){
            case "robot":
                chineseName = "智能机器人";
                break;
            case "phone":
                chineseName = "智能手机";
                break;
            case "pc":
                chineseName = "笔记本电脑";
                break;
            case "UAV":
                chineseName = "无人机";
                break;
            case "camera":
                chineseName = "智能摄像机";
                break;
            default:
                chineseName="";
        }
        return chineseName;
    }
}