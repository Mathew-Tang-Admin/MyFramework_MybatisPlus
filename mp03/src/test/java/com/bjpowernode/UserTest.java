package com.bjpowernode;

import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import com.bjpowernode.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //启动类 SpringBoot
@SpringBootTest
class UserTest {
    // @Qualifier("userMapper1")
    // @Autowired
    @Resource(name = "userMapper1")
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 记录一下，我用MybatisX生成项目结构时，*.xml那里，我写了com.bjpowernode.mapper
     *  但是只生成了mapper，于是我使用Shift+F6写了com.bjpowernode.mapper
     *  科室我忘记了他是目录，不是包，用那个只会生成一个目录
     *  要使用Directory，输入com\bjpowernode\mapper
     * <br/>
     * <font color="red"></font>
     * 测试实体类别名等
     */
    @Test
    void testSelectByNameUser() {
        // User tom = userMapper.selectByNameUser("Tom");
        // System.out.println(tom);

        int tom1 = userMapper.deleteByNameAndAge("Tom", 18);
        System.out.println(tom1);
    }

    @Test
    void testMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testService() {
        User byId = userService.getById(1L);
        System.out.println(byId);
    }
}
