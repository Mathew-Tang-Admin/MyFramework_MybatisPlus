package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 分页插件
 * @author MathewTang
 */
@SpringBootTest
public class PageTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectPage() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 指定分页对象，分页对象包含分页信息 IPage
        IPage<User> page = new Page<>(1, 3);
        // 指定查询
        userMapper.selectPage(page,queryWrapper);

        // 获取分页查询信息
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("总页数：" + page.getPages());
        System.out.println("总条数：" + page.getTotal());
        System.out.println("分页数据：" + page.getRecords());
    }

    @Test
    void selectPage2() {
        Page<User> page = new Page<>(1, 2);
        userMapper.selectByName("Mary",page);

        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("总页数：" + page.getPages());
        System.out.println("总条数：" + page.getTotal());
        System.out.println("分页数据：" + page.getRecords());
    }
}
