package com.bjpowernode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjpowernode.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author MathewTang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * TODO: 根据name(假设name是唯一的)查询user
     * P86，改造成使用分页插件，原型只传了name一个参数,返回类型是User，加入注解
     * 查了mybatis笔记，多个参数要使用注解@Param("name"),sql语句中参数类型不用写
     * 怎么老师 没有加注解也可以正常使用
     *
     * 这里有红色下划线的原因是 MyBatisX检测到项目下有同名的实体类的原因
     * @param name String
     * @param page IPage<User>
     * @return {@link IPage<User>}
     */
    IPage<User> selectByName(@Param("name")String name, @Param("page")IPage<User> page);
}
