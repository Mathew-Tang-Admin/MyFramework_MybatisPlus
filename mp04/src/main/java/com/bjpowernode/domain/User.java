package com.bjpowernode.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 *
 * @TableName powershop_user
 */
@TableName(value ="powershop_user")
@Data
@Alias("userAlias")
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
