package com.group.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.lesson.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: hwj
 * @Date: 2021/9/10 9:48
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
