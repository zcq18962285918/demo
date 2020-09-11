package com.vue.demo.service;

import com.vue.demo.entity.Authority;
import com.vue.demo.entity.Role;
import com.vue.demo.mapper.AuthorityMapper;
import com.vue.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    AuthorityMapper authorityMapper;

    public List<Role> list() {
        List<Role> roleList = roleMapper.list();

        roleList.forEach(role -> {
            List<Authority> objects = new ArrayList<>();
            List<Integer> authorityId = roleMapper.getAuthorityIdByRoleId(role.getId());
            //所有权限
            List<Authority> authorityList = authorityService.list(0);
            authorityList.forEach(authority -> {
                if (authorityId.contains(authority.getId())) {
                    aa(authority, authorityId);
                    objects.add(authority);
                }
            });
            role.setChildren(objects);
        });

        return roleList;
    }

    public void aa(Authority authority, List<Integer> ids) {
        List<Authority> children = authority.getChildren();
        ArrayList<Authority> nList = new ArrayList<>();
        if (children != null) {
            children.forEach(a -> {
                if (ids.contains(a.getId())) {
                    nList.add(a);
                }
            });
        }
        authority.setChildren(new ArrayList<>());
        authority.setChildren(nList);
        authority.getChildren().forEach(authority1 -> {
            aa(authority1, ids);
        });
    }


}
