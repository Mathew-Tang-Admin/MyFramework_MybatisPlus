package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.enums.GenderEnum;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void enumTest() {
        User user = new User();
        user.setName("liu");
        user.setAge(29);
        user.setEmail("liu@bjpowernode.com");
        user.setStatus(1);
        user.setGender(GenderEnum.WOMAN);

        int count = userMapper.insert(user);
    }
}
