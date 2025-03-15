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
// @Controller
// @ResponseBody
@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/user/selectAll")
    public List<User> selectAll() {
        List<User> users = userService.selectAll();
        return users;
    }
}
