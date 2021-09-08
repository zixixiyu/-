package com.group.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.entity.User;
import com.group.lesson.mapper.UserMapper;
import com.group.lesson.service.UserService;
import com.group.lesson.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/8 13:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserVo> getAllUser(Integer pageNum) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.select("username","registryDate","email","mobile");
        queryWrapper.last("limit "+(pageNum-1)*10+",10");
        List<User> users = userMapper.selectList(queryWrapper);
        ArrayList<UserVo> userVos = new ArrayList<>();
        for (User user:users){
            UserVo userVo = new UserVo();
            userVo.setEmail(user.getEmail());
            userVo.setMobile(user.getMobile());
            userVo.setRegistryDate(user.getRegistryDate());
            userVo.setUsername(user.getUsername());
            userVos.add(userVo);
        }
        return userVos;
    }

    @Override
    public Integer getUserNum() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        return userMapper.selectCount(userQueryWrapper);
    }
}
