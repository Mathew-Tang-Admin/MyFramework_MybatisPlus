package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author MathewTang
 */
@SpringBootTest
public class LockTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void updateTest() {
        User user = userMapper.selectById(6L);
        System.out.println("查询的结果： " + user);
        user.setName("迈克li");
        userMapper.updateById(user);
    }

    @Test
    void updateTest2() {
        // 模拟操作1的查询操作
        User user1 = userMapper.selectById(6L);
        System.out.println("操作1的查询结果： " + user1);

        // 模拟操作2的查询操作
        User user2 = userMapper.selectById(6L);
        System.out.println("操作2的查询结果： " + user2);

        // 模拟操作2的修改操作
        user2.setName("迈克lisi");
        userMapper.updateById(user2);

        // 模拟操作1的修改操作
        user1.setName("迈克zhangsan");
        userMapper.updateById(user1);
    }
}
