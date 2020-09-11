package com.vue.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String role;
    private List<Authority> children;
}
