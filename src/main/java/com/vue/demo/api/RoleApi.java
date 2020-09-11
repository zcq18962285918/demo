package com.vue.demo.api;

import com.vue.demo.entity.Role;
import com.vue.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RoleApi {

    @Autowired
    RoleService roleService;

    @RequestMapping("/roles")
    public List<Role> list() {
        return roleService.list();
    }

    @RequestMapping("/add")
    public void add(@RequestBody Role role){

    }
}
