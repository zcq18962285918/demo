package com.vue.demo.entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private Integer sex;
    private Integer departmentId;
    private Department department;
    private Integer valid;
}
