package com.bjpowernode.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import com.bjpowernode.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 注解：@DS("slave")，指定数据源
 *
* @author Administrator
* @description 针对表【powershop_user】的数据库操作Service实现
* @createDate 2025-03-24 23:45:55
*/
@Service
@DS("slave_1")
public class UserService2Impl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




