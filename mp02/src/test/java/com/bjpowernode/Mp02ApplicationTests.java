package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import com.bjpowernode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mp02ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /** TODO: UserMapper查询所有 */
    @Test
    void selectList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    /** TODO: UserMapper简单添加 */
    @Test
    void insert() {
        User user = new User();
        user.setId(6L);
        user.setName("Nike");
        user.setAge(33);
        user.setEmail("test6@bjpowernode.com");

        int count = userMapper.insert(user);
    }

    /** TODO: UserMapper简单删除 */
    @Test
    void deleteOne() {
        int count = userMapper.deleteById(6L);
    }

    /** TODO: UserMapper简单修改 */
    @Test
    void updateById() {
        User user = new User();
        user.setId(6L);
        user.setName("迈克");
        user.setAge(35);
        user.setEmail("mike@bjpowernode.com");

        int count = userMapper.updateById(user);
    }

    /** TODO: UserMapper查询单个 */
    @Test
    void selectById() {
        User user = userMapper.selectById(6L);
        System.out.println(user);
    }


    // UserService添加
    @Test
    void insertService() {
        User user = new User();
        user.setId(7L);
        user.setName("zhangsan");
        user.setAge(35);
        user.setEmail("zhangsan@bjpowernode.com");

        boolean result = userService.save(user);
    }

    // UserService删除
    @Test
    void deleteService() {
        userService.removeById(7L);
    }

    // UserService修改
    @Test
    void updateService() {
        User user = new User();
        user.setId(6L);
        user.setAge(40);

        boolean result = userService.updateById(user);
    }

    // UserService查询所有数据
    @Test
    void selectService() {
        List<User> users = userService.selectList();
        System.out.println(users);
    }

    // UserService查询单条数据
    @Test
    void selectOneService() {
        User user = userService.getById(6L);
        System.out.println(user);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 5L);
        User userOne = userService.getOne(wrapper);
        System.out.println(userOne);
    }

    // UserMapper测试自定义方法
    @Test
    void customMethod() {
        User user = userMapper.selectByName("Tom");
        System.out.println(user);
    }
}
