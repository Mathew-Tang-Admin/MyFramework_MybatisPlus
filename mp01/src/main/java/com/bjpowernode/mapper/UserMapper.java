package com.bjpowernode.mapper;

import com.bjpowernode.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MathewTang
 */
@Mapper
public interface UserMapper {
    List<User> selectAll();
}
