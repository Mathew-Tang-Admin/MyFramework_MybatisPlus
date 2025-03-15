package com.bjpowernode.controller;

import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MathewTang
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/selectList")
    public List<User> selectList(){
        return userService.selectList();
    }
}
