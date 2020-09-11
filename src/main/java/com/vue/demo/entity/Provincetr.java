package com.vue.demo.entity;

import java.util.List;

public class Provincetr {

  private long id;
  private long parent_id;
  private String city_name_zh;
  private String city_name_en;
  private long city_level;
  private String city_code;
  private List<Provincetr> children;

  public List<Provincetr> getChildren() {
    return children;
  }

  public void setChildren(List<Provincetr> children) {
    this.children = children;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getParent_id() {
    return parent_id;
  }

  public void setParent_id(long parent_id) {
    this.parent_id = parent_id;
  }

  public String getCity_name_zh() {
    return city_name_zh;
  }

  public void setCity_name_zh(String city_name_zh) {
    this.city_name_zh = city_name_zh;
  }

  public String getCity_name_en() {
    return city_name_en;
  }

  public void setCity_name_en(String city_name_en) {
    this.city_name_en = city_name_en;
  }

  public long getCity_level() {
    return city_level;
  }

  public void setCity_level(long city_level) {
    this.city_level = city_level;
  }

  public String getCity_code() {
    return city_code;
  }

  public void setCity_code(String city_code) {
    this.city_code = city_code;
  }
}
