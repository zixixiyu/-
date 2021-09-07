package com.group.lesson;

import com.group.lesson.entity.User;
import com.group.lesson.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LessonApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println(user.getId()+" "+user.getUsername());
    }

}
