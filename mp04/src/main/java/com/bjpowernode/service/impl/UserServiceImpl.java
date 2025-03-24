package com.bjpowernode.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.domain.User;
import com.bjpowernode.service.UserService;
import com.bjpowernode.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【powershop_user】的数据库操作Service实现
* @createDate 2025-03-24 23:45:55
*/
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




