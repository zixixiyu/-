package com.group.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.entity.Manager;
import com.group.lesson.mapper.ManagerMapper;
import com.group.lesson.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: hwj
 * @Date: 2021/9/9 11:05
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public boolean exist(String username) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Integer integer = managerMapper.selectCount(wrapper);
        return integer > 0;
    }
}
