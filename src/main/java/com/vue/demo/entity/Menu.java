package com.vue.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;
    private String authName;
    private String path;
    private Integer pid;
    private List<Menu> children;
    private String icon;
}
