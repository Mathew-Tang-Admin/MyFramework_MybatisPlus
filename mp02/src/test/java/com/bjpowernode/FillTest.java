package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.enums.GenderEnum;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;


@SpringBootTest
class FillTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void fillTest() {
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

        int ret = userMapper.insert(user);
    }

    @Test
    void testFillUpdate() {
        User user = new User();
        user.setId(1902802681852866561L);
        user.setName("lisi");
        user.setAge(35);
        user.setEmail("lisi@bjpowernode.com");
        user.setGender(GenderEnum.MAN);
        user.setStatus(1);

        HashMap<String, String> map = new HashMap<>();
        map.put("tel","13388889999");
        map.put("phone","010-1234567");

        user.setContact(map);

        int ret = userMapper.updateById(user);
    }
}
