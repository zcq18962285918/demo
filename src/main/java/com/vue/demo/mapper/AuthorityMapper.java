package com.vue.demo.mapper;

import com.vue.demo.entity.Authority;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorityMapper {

    @Select(value = "select * from authority where pid = #{pid}")
    List<Authority> list(@Param("pid") Integer pid);

    @Select(value = "select * from authority where id = #{id}")
    Authority getById(@Param("id") Integer id);

    @Select(value = "select authorityId from role_authority where roleId = #{id}")
    List<String> getByRoleId(@Param("id") String id);

    @Insert(value = "insert into authority (id, authority, pid) values(null, #{authority.authority}, #{authority.pid})")
    void addAuthority(@Param("authority") Authority authority);
}
