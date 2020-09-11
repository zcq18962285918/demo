package com.vue.demo.api;

import com.vue.demo.entity.Department;
import com.vue.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//'Access-Control-Allow-Origin': '*' 跨域后台用CrossOrigin
@CrossOrigin
@RequestMapping("/department")
public class DepartmentApi {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/list")
    public List<Department> list() {
        return departmentService.list();
    }

    @RequestMapping("/getById")
    public Department getById(Integer id) {
        return departmentService.getById(id);
    }
}
