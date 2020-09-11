package com.vue.demo.mapper;


import com.vue.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> list(String username);

    @Select(value = "select * from user where id = #{id}")
    User get(@Param("id") String id);

    @Insert(value = "insert into user values (null, #{user.username}, #{user.password}, #{user.fullname}, #{user.sex}, #{user.departmentId}, #{user.valid})")
    void add(@Param("user") User user);

    void delete(String id);

    @Update(value = "<script>update user <set> " +
            "<if test = 'user.username != null'> username = #{user.username},</if>" +
            "<if test = 'user.password != null'> password = #{user.password},</if>" +
            "<if test = 'user.sex != null'> sex = #{user.sex},</if>" +
            "<if test = 'user.departmentId != null'> departmentId = #{user.departmentId},</if>" +
            "<if test = 'user.fullname != null'> fullname = #{user.fullname},</if>" +
            "<if test = 'user.valid != null'> valid = #{user.valid},</if></set>" +
            "where id = #{user.id}</script>")
    void modify(@Param("user") User user);

    @Select(value = "select id,username,password from user where username = #{user.username} and password = #{user.password}")
    User checkUser(@Param("user") User user);
}
