package com.group.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.lesson.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hwj
 * @Date: 2021/9/10 9:49
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
