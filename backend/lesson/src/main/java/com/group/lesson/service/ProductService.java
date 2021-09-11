package com.group.lesson.service;

import com.group.lesson.entity.Product;
import com.group.lesson.vo.FrontProductVo;
import com.group.lesson.vo.ProductVo;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

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

    /**
     * 产品的上下架
     * @param productName
     * @return
     */
    boolean shxjia(String productName);

    /**
     * 插入产品数据
     * @param postInfo
     * @param imgName
     * @return
     */
    boolean insertProduct(Map<String, String> postInfo,String imgName);

    /**
     * 获取产品前端展示
     * @param category
     * @return
     */
    List<FrontProductVo> getPro(String category);

    /**
     * 获取某类型全部产品
     * @param category
     * @return
     */
    List<FrontProductVo> getAllPro(String category);

    /**
     * 获取某个产品的详细信息
     * @param productId
     * @return
     */
    Product getOneProduct(String productId);
}
