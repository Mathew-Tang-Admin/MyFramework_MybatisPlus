package com.bjpowernode.domain;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.bjpowernode.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * 注解：@TableName("powershop_user")，数据库表名和实体类名不同时，通过这个注解配置
 * 添加extends Model<User>: 使用ActiveRecord模式
 * @author MathewTang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// @TableName("powershop_user")
// ActiveRecord模式 下添加  extends Model<User>
@TableName(autoResultMap = true) // 表示将数据库中查出的数据封装到map集合
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

    /** 注解@TableLogic：配置该字段为逻辑删除字段 */
    // @TableLogic(value = "1",delval = "0")
    private Integer status;
    /** 0:男,1女 */
    private GenderEnum gender;
    /** 联系方式
     * 注解@TableField(typeHandler = FastjsonTypeHandler.class):
     *   指定字符串处理器将map集合通过处理器变成JSON格式字符串
     *   配合 @TableName(autoResultMap = true) 注解使用 */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String,String> contact;
    /** 插入时填充该数据 */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /** 插入、修改时填充该数据 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /** 测试乐观锁 */
    @Version
    private Integer version;

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
