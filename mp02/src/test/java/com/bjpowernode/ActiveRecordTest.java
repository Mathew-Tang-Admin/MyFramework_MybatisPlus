package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.bjpowernode.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * TODO: 在ActiveRecord中 万事万物皆对象
 *   它把所有的人数据都放到了对象中 让对象完成增删改查操作
 */
@SpringBootTest
class ActiveRecordTest {

    /** TODO: 添加操作 */
    @Test
    void activeRecordAdd() {
        User user = new User();
        user.setName("zhang");
        user.setAge(35);
        user.setEmail("zhang@bjpowernode.com");
        boolean ret = user.insert();
    }

    /** TODO: 删除操作 */
    @Test
    void activeRecordDelete() {
        User user = new User();
        user.setId(1902675990828572674L);
        boolean ret = user.deleteById();
    }

    /** TODO: 修改操作 */
    @Test
    void activeRecordUpdate() {
        User user = new User();
        user.setId(7L);
        user.setAge(50);
        boolean ret = user.updateById();
    }

    /** TODO: 查询操作 */
    @Test
    void activeRecordSelect() {
        User user = new User();
        user.setId(7L);
        User ret = user.selectById();
        System.out.println(ret);
    }

    /** TODO: SimpleQuery 工具类 */
    @Test
    void testList() {
        /* wrapper: 条件构造器, sFunction: 需要的列, peeks: 后续操作 */
        List<Long> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getId);
        System.out.println(list);
    }

    @Test
    void testList2() {
        /* wrapper: 条件构造器, sFunction: 需要的列, peeks: 后续操作 */
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"),
                User::getName, user -> {
                    Optional.of(user.getName()).map(String::toLowerCase).ifPresent(user::setName);
                });
        System.out.println(list);
    }

    @Test
    void testMap() {
        Map<Long, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>(), User::getId);
        System.out.println(map);
    }

    @Test
    void testMap2() {
        Map<Long, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>().eq(User::getId,1L), User::getId);
        System.out.println(map);
    }

    @Test
    void testMap3() {
        Map<Long, String> map = SimpleQuery.map(new LambdaQueryWrapper<User>(), User::getId, User::getName);
        System.out.println(map);
    }

    @Test
    void testGroup() {
        Map<String, List<User>> map = SimpleQuery.group(new LambdaQueryWrapper<User>(), User::getName);
        System.out.println(map);
    }
}
