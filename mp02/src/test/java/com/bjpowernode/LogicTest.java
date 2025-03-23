package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MathewTang
 */
@SpringBootTest
public class LogicTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void logicDelete() {
        int count = userMapper.deleteById(6L);
    }

    @Test
    void logicSelect() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
}
