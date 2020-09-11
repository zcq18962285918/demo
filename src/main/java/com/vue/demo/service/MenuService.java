package com.vue.demo.service;

import com.vue.demo.entity.Menu;
import com.vue.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> listMenu() {
        List<Menu> menuList = menuMapper.listMenu(0);
        list(menuList);
        return menuList;
    }

    public void list(List<Menu> menuList) {
        if (menuList.size() == 0) {
            return;
        }
        menuList.forEach(menu -> {
            List<Menu> menus = menuMapper.listMenu(menu.getId());
            menu.setChildren(menus);
            list(menus);
        });
    }
}
