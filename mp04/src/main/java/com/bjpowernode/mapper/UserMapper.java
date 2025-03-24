package com.bjpowernode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjpowernode.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @author Administrator
* @description 针对表【powershop_user】的数据库操作Mapper
* @createDate 2025-03-24 01:11:55
* @Entity com.bjpowernode.domain.User
*/
// @Repository("userMapper1")
@Component("userMapper1")
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 红色波浪线是因为 MyBatisX插件的原因
     * @param name String
     * @return User
     */
    User selectByNameUser(String name);

    /**
     * TODO: 此处待完成
     * @param name {@link String}
     * @param age {@link Integer}
     * @return {@link int}
     */
    int deleteByNameAndAge(@Param("name") String name, @Param("age") Integer age);
    /**
     * TODO: 此处待完成
     * @param name {@link String}
     * @param age {@link Integer}
     * @return {@link int}
     */
    int updateNameByAge(@Param("name") String name, @Param("age") Integer age);
    /**
     * TODO: 此处待完成
     * @param beginAge {@link Integer}
     * @param endAge {@link Integer}
     * @return {@link List<User>}
     */
    List<User> selectAllByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);
}




