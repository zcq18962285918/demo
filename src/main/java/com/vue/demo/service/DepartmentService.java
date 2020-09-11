package com.vue.demo.service;

import com.vue.demo.entity.Department;
import com.vue.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> list() {
        return departmentMapper.list();
    }

    public Department getById(Integer id) {
        return departmentMapper.getById(id);
    }
}
