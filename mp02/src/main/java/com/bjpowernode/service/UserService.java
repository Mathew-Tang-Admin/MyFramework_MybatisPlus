package com.bjpowernode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjpowernode.domain.User;

import java.util.List;

/**
 * @author MathewTang
 */
public interface UserService extends IService<User> {
    /**
     * TODO: 此处待完成
     * @return {@link List<User>}
     */
    List<User> selectList();

}
