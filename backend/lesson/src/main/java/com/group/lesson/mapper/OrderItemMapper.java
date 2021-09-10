package com.group.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.lesson.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hwj
 * @Date: 2021/9/10 10:17
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
