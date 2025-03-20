package com.bjpowernode.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注解：@TableName("powershop_user")，数据库表名和实体类名不同时，通过这个注解配置
 * @author MathewTang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// @TableName("powershop_user")
// ActiveRecord模式 下添加  extends Model<User>
public class User extends Model<User> {
    // @TableId(type = IdType.AUTO) // 主键自增策略，配合数据库设置
    // @TableId(type = IdType.INPUT)
    // @TableId(type = IdType.ASSIGN_ID) // 雪花算法
    // @TableId(type = IdType.NONE) // NONE或者不使用该注解 即 NONE策略
    @TableId // ActiveRecord模式 下添加
    private Long id;
    // @TableId(type = IdType.ASSIGN_UUID)
    // private String id;
    /** 数据库字段名 和 实体类变量名 映射 */
    // @TableField("username")    @TableField("name")
    private String name;
    /** 在sql查询结果中应隐藏 false */
    @TableField(select = true)
    private Integer age;
    private String email;
    // @TableField("`desc`")
    // private String desc;

    /** 本字段在数据库中不存在，但是在实体类中存在，使用该注解在查询结果中去掉改字段 */
    @TableField(exist = false)
    private String online;

    // 变量名称
    // private String name;

    // 属性
    // getName -> Name -> name


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
