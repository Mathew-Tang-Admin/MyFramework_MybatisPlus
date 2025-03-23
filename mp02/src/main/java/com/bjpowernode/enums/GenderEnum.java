package com.bjpowernode.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;

/**
 * @author MathewTang
 */
@AllArgsConstructor
public enum GenderEnum {
    /** 男 */
    MAN(0,"男")
    ,
    /** 女 */
    WOMAN(1,"女");
    @EnumValue
    private Integer gender;
    private String genderName;
}
