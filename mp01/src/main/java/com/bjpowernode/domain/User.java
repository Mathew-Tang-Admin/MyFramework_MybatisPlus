package com.bjpowernode.domain;


import lombok.*;

/**
 * @author MathewTang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
