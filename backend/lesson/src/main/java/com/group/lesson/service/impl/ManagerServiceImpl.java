package com.group.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.entity.Manager;
import com.group.lesson.mapper.ManagerMapper;
import com.group.lesson.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: hwj
 * @Date: 2021/9/9 11:05
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public boolean exist(String username) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Integer integer = managerMapper.selectCount(wrapper);
        return integer > 0;
    }

    @Override
    public String login(String username, String password) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);

        Integer integer = managerMapper.selectCount(wrapper);
        if (integer>0) {
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(token,username);

            return token;
        }
        return null;
    }
}
