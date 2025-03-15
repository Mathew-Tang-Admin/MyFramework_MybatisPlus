package com.bjpowernode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjpowernode.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MathewTang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * TODO: 根据name(假设name是唯一的)查询user
     * @param name String
     * @return {@link User}
     */
    User selectByName(String name);
}
