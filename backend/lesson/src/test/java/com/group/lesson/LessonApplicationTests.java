package com.group.lesson;

import com.group.lesson.entity.User;
import com.group.lesson.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
class LessonApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }
    @Test
    void t1(){
        User user = new User();
        user.setEmail("11");
        user.setMobile("183594");
        user.setPassword("8522");
        user.setUsername("刘凯");
        user.setRegistryDate(new Date());
        userMapper.insert(user);
    }
}
