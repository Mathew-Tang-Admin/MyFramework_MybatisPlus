package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.service.impl.UserService2Impl;
import com.bjpowernode.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mp04ApplicationTests {

    @Autowired
    private UserServiceImpl userService1;
    @Autowired
    private UserService2Impl userService2;

    @Test
    void select1() {
        User byId = userService1.getById(1L);
        System.out.println(byId);
    }

    @Test
    void select2() {
        User byId = userService2.getById(1L);
        System.out.println(byId);
    }

}
