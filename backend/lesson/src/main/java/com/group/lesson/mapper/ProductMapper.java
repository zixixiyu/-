package com.group.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.lesson.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hwj
 * @Date: 2021/9/9 14:16
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
