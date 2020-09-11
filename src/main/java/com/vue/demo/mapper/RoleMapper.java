package com.vue.demo.mapper;

import com.vue.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select(value = "select * from role")
    List<Role> list();

    @Select(value = "select AuthorityId from role_authority where roleId = #{id}")
    List<Integer> getAuthorityIdByRoleId(@Param("id") Integer id);
}
