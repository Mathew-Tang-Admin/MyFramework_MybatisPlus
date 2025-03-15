package com.bjpowernode;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.domain.User;
import com.bjpowernode.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * 等值查询、模糊查询、模糊查询、判空查询、包含查询、分组查询、聚合查询、排序查询、func查询、逻辑查询、自定义条件查询
 * @author MathewTang
 */
@SpringBootTest
public class QueryTest {

    @Autowired
    private UserMapper userMapper;

    /** TODO: 等值查询 之 QueryWrapper */
    @Test
    void eq() {
        // 1.创建条件查询对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 2.设置查询条件，指定查询的字段和匹配的值
        wrapper.eq("name", "Jack");
        // 3.进行条件查询
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /** TODO: 等值查询 之 LambdaQueryWrapper */
    @Test
    void eq2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, "Jack");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /** TODO: 等值查询 之 null的判断 */
    @Test
    void eqForIsNull() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, null);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /** TODO: 等值查询 之 null的判断 解决 */
    @Test
    void eqForIsNull2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        String name = null;
        // String name = "Jone";
        wrapper.eq(name != null, User::getName, name);
        // User user = userMapper.selectOne(wrapper);
        // 有值，查询出一个，没有值，查询出所有
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /** TODO: 等值查询 之 多条件查询 */
    @Test
    void allEq1() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, "Tom");
        queryWrapper.eq(User::getAge, 28);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /** TODO: 等值查询 之 多条件查询 */
    @Test
    void allEq2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        // map.put("age", 28);
        map.put("age", null);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        /*
            参数null2IsNull:表示对于为null的条件是否判断isNull
            对于空值怎么处理，对于空值，是不去判断，不作为连接条件，还是直接判空
            false: 不作为连接条件
            true: 直接判空，以空值连接
         */
        queryWrapper.allEq(map, false);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /** TODO: 等值查询 之 不等操作 */
    @Test
    void ne() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(User::getName, "Tom");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 范围查询 之 大于操作 */
    @Test
    void gt() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        queryWrapper.gt(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        // users.stream().forEach(System.out::println);
        // users.forEach(System.out::println);
        // System.out.println(Arrays.toString(users.toArray()));
        System.out.println(users);
    }

    /** TODO: 范围查询 之 大于等于操作 */
    @Test
    void ge() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        queryWrapper.ge(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 范围查询 之 小于操作 */
    @Test
    void lt() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Integer age = 30;
        queryWrapper.lt(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 范围查询 之 小于等于操作 */
    @Test
    void le() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(User::getAge, 30);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 范围查询 之 介于操作 */
    @Test
    void between() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(User::getAge, 18, 30);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 范围查询 之 非介于操作 */
    @Test
    void notBetween() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notBetween(User::getAge, 18, 30);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 模糊查询 之 模糊匹配 */
    @Test
    void like() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(User::getName, "J");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 模糊查询 之 不匹配模糊查询 */
    @Test
    void notLike() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notLike(User::getName, "J");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 模糊查询 之 左模糊匹配 */
    @Test
    void likeLeft() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeLeft(User::getName, "e");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 模糊查询 之 右模糊匹配 */
    @Test
    void likeRight() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(User::getName, "J");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 判空查询 之 为空查询 */
    @Test
    void isNull3() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNull(User::getName);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 判空查询 之 非空查询 */
    @Test
    void isNotNull() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.isNotNull(User::getName);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 包含查询
     * 字段=值 or 字段=值 -> in */
    @Test
    void in() {
        ArrayList<Integer> age = new ArrayList<>();
        Collections.addAll(age, 18, 20, 22);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 包含查询
     * 字段!=值 and 字段!=值 -> notIn */
    @Test
    void notIn() {
        ArrayList<Integer> age = new ArrayList<>();
        Collections.addAll(age, 18, 20, 22);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notIn(User::getAge, age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 包含查询 */
    @Test
    void inSql() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.inSql(User::getAge, "28,20,22");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 包含查询 */
    @Test
    void inSql2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.inSql(User::getAge, "select age from powershop_user where age > 20");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 包含查询 */
    @Test
    void notInSql() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notInSql(User::getAge, "28,20,22");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 包含查询 */
    @Test
    void notInSql2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.notInSql(User::getAge, "select age from powershop_user where age > 20");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 分组查询 */
    @Test
    void groupBy() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 分组字段
        queryWrapper.groupBy("age");
        // 查询字段
        queryWrapper.select("age,count(*) as field_count");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);

        /*// 以下是我根据queryWrapper.select()想出的例子，确实这个方法指定的是查询字段
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 查询字段
        wrapper.select("name,age,email");
        // 查询条件
        wrapper.eq("name", "Tom");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);*/
    }


    /** TODO: 聚合查询 */
    @Test
    void having() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 分组字段
        queryWrapper.groupBy("age");
        // 查询字段
        queryWrapper.select("age,count(*) as field_count");
        // 聚合条件筛选
        queryWrapper.having("field_count = 1");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
    }


    /** TODO: 排序查询 之 升序 */
    @Test
    void orderByAsc() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(User::getAge, User::getId);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 排序查询 之 降序 */
    @Test
    void orderByDesc() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // queryWrapper.orderByAsc(User::getAge).orderByDesc(User::getName);  // 年龄升序，姓名降序
        queryWrapper.orderByDesc(User::getAge, User::getId);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 排序查询 之 复合排序 */
    @Test
    void orderBy() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 设置排序字段和排序的方式
        // queryWrapper.orderByAsc(User::getAge).orderByDesc(User::getName);  // 年龄升序，姓名降序
        // 参数1：如果排序字段的值为null的时候，是否还要作为排序字段参与排序
        // 参数2：是否是升序排序，参数3：排序字閡
        // queryWrapper.orderBy(true, false, User::getDesc); // 为空，不会作为排序字段进行拼接
        queryWrapper.orderBy(true, true, User::getAge);
        queryWrapper.orderBy(true, false, User::getId);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: func查询 之  */
    @Test
    void func() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 构建逻辑判断语句，可能会根据不同的情况拼接不同的查询条件
        /* queryWrapper.func(new Consumer<LambdaQueryWrapper<User>>() {
            @Override
            public void accept(LambdaQueryWrapper<User> userLambdaQueryWrapper) {
                // if (false) {
                //     userLambdaQueryWrapper.eq(User::getId, 1);
                // } else {
                //     userLambdaQueryWrapper.ne(User::getId, 1);
                // }
                boolean condition = false; // 根据实际业务替换条件值
                queryWrapper.eq(condition,  User::getId, 1)
                        .ne(!condition, User::getId, 1);
            }
        }); */
        queryWrapper.func(userLambdaQueryWrapper -> {
            boolean condition = false; // 根据实际业务替换条件值
            queryWrapper.eq(condition,  User::getId, 1)
                    .ne(!condition, User::getId, 1);
        });
        // 完成查询
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 逻辑查询 之 and */
    @Test
    void and() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getAge, 22).lt(User::getAge, 30); // and(条件)
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 逻辑查询 之 and */
    @Test
    void and2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, "Tom").and(userLambdaQueryWrapper -> {
            userLambdaQueryWrapper.gt(User::getAge, 26).or().lt(User::getAge,22);
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 逻辑查询 之 or */
    @Test
    void or() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(User::getAge, 20).or().gt(User::getAge,23); // age < 20 || age > 23
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 逻辑查询 之 or */
    @Test
    void or2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, "Tom").or(wrapper -> {
            wrapper.gt(User::getAge,22).lt(User::getAge,26);
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /** TODO: 逻辑查询 之 nested (嵌套) */
    @Test
    void nested() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.nested(wrapper -> {
            wrapper.eq(User::getName,"Tom").ne(User::getAge,22);
        });
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: 自定义条件查询 */
    @Test
    void apply() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 直接把这里的查询条件拼接到 where 属性之后
        queryWrapper.apply("id = 1");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    /** TODO: last查询  */
    @Test
    void last() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // LIMIT 1, 2的语义是：跳过1条记录（偏移量=1），取后续2条记录。
        // 分页的正确偏移量公式应为：offset = (页码-1) * 每页数量。
        // 即从第几条开始，每页几条
        queryWrapper.last("limit 0,2");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
}
