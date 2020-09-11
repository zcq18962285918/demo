package com.vue.demo.api;

import com.vue.demo.entity.Menu;
import com.vue.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//'Access-Control-Allow-Origin': '*' 跨域后台用CrossOrigin
@CrossOrigin
@RequestMapping("/menu")
public class MenuApi {
    @Autowired
    MenuService menuService;

    @RequestMapping("/listMenu")
    public List<Menu> listMenu(){
        return menuService.listMenu();
    }
}
