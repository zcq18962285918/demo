package com.vue.demo.mapper;

import com.vue.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select(value = "select * from department")
    List<Department> list();

    @Select(value = "select * from department where id = #{id}")
    Department getById(@Param("id") Integer id);
}
