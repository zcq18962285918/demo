package com.vue.demo.mapper;

import com.vue.demo.entity.Provincetr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvinceMapper {

    @Select("select * from provincetr where parent_id = #{pid}")
    List<Provincetr> list(@Param("pid")long pid);

    @Select("select * from provincetr")
    List<Provincetr> listAll();

}
