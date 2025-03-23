package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.enums.GenderEnum;
import com.bjpowernode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author MathewTang
 */
@SpringBootTest
public class UpdateAllTest {
    @Autowired
    private UserService userService;

    @Test
    void updateAll() {
        User user = new User();
        user.setGender(GenderEnum.MAN);

        userService.saveOrUpdate(user,null);
    }
}
