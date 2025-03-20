package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 主键策略
 * @author MathewTang
 */
@SpringBootTest
public class PrimaryKeyTest {

    @Autowired
    private UserMapper userMapper;

    /** 测试主键策略 */
    @Test
    void primary() {
        User user = new User();
        user.setName("Mary");
        user.setAge(35);
        user.setEmail("mary@bjpowernode.com");

        // user.setId(7L); // INPUT策略时

        int count = userMapper.insert(user);
    }
}
