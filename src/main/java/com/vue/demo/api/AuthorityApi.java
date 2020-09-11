package com.vue.demo.api;

import com.vue.demo.entity.Authority;
import com.vue.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/authority")
@RestController
@CrossOrigin
public class AuthorityApi {
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/list")
    public List<Authority> list(Integer pid){
        return authorityService.list(pid);
    }

    @RequestMapping("/getByRoleId")
    public List<String> getByRoleId(String id) {
        return authorityService.getByRoleId(id);
    }

    @RequestMapping("/add")
    public void add(@RequestBody Authority authority){
        authorityService.addAuthority(authority);
    }

}
