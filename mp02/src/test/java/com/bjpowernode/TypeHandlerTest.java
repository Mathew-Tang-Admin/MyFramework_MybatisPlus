package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.enums.GenderEnum;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class TypeHandlerTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void typeHandler() {
        User user = new User();
        user.setName("li");
        user.setAge(28);
        user.setEmail("li@bjpowernode.com");
        user.setGender(GenderEnum.MAN);
        user.setStatus(1);

        HashMap<String, String> map = new HashMap<>();
        map.put("tel","13388889999");
        map.put("phone","010-1234567");

        user.setContact(map);

        userMapper.insert(user);
    }

    @Test
    void typeHandlerSelect() {
        User user = userMapper.selectById(1902794590541365249L);
        System.out.println(user);
    }
}
