package com.group.lesson.service;

import com.group.lesson.vo.ProductVo;

import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/10 8:47
 */
public interface ProductService {
    /**
     * 获取商品总条数
     * @return
     */
    Integer getProductNum();

    /**
     * 获取一定页数的产品
     * @param pageNum
     * @return
     */
    List<ProductVo> getPageProduct(Integer pageNum);
}
