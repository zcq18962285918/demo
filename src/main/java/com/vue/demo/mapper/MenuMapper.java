package com.vue.demo.mapper;

import com.vue.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from Menu where pid = #{pid}")
    List<Menu> listMenu(Integer pid);
}
