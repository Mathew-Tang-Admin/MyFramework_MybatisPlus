package com.bjpowernode.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName powershop_user
 */
@TableName(value ="powershop_user")
@Alias("userAlias")
@Data
public class User implements Serializable {
    /**
     * 主键 ID
     */
    @TableId
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 逻辑删除(1可用,0不可用)
     */
    private Integer status;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 联系方式
     */
    private String contact;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
