package com.vue.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vue.demo.entity.Department;
import com.vue.demo.entity.User;
import com.vue.demo.mapper.DepartmentMapper;
import com.vue.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    // 查询所有
    public PageInfo<User> list(String username, Integer page, Integer pagesize) {
        PageInfo<User> pageInfo = PageHelper.startPage(page, pagesize).doSelectPageInfo(() -> userMapper.list(username));
        List<User> userList = pageInfo.getList();
        userList.forEach(user -> {
            Department department = departmentMapper.getById(user.getDepartmentId());
            user.setDepartment(department);
        });
        return pageInfo;
    }

    // 查询单个,条件搜索search
    public User get(String id) {
        User user = userMapper.get(id);
        Department depar = departmentMapper.getById(user.getDepartmentId());
        user.setDepartment(depar);
        return user;
    }

    // 增加,创建create
    public void add(User user) {
        userMapper.add(user);
    }

    // 删除
    public void delete(String id) {
        userMapper.delete(id);
    }

    // 修改
    public void modify(User user) {
        userMapper.modify(user);
    }

    public User checkUser(User user) {
        return userMapper.checkUser(user);
    }
}
