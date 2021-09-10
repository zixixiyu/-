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

import java.util.ArrayList;
import java.util.List;

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
}
