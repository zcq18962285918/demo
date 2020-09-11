package com.vue.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Authority {
    private Integer id;
    private Integer pid;
    private String authority;
    private List<Authority> children;

}
