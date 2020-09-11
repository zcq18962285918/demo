package com.vue.demo.service;

import com.vue.demo.entity.Authority;
import com.vue.demo.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    public List<Authority> list(Integer pid) {

        List<Authority> authorityList = authorityMapper.list(pid);

        list(authorityList);

        return authorityList;
    }

    public void list(List<Authority> authorityList) {
        authorityList.forEach(authority -> {
            List<Authority> list = authorityMapper.list(authority.getId());
            if (list.size() != 0) {
                authority.setChildren(list);
                list(list);
            }
        });

    }

    public List<String> getByRoleId(String id) {
        return authorityMapper.getByRoleId(id);
    }

    public void addAuthority(Authority authority) {
        authorityMapper.addAuthority(authority);
    }
}
