package com.group.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.lesson.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 2 * @Author: hwj
 * 3 * @Date: 2021/9/6 18:29
 * 4
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
