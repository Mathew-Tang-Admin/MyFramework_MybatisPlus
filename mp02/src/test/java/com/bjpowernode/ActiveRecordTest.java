package com.bjpowernode;

import com.bjpowernode.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
}
