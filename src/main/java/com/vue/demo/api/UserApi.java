package com.vue.demo.api;

import com.github.pagehelper.PageInfo;
import com.vue.demo.entity.User;
import com.vue.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//'Access-Control-Allow-Origin': '*' 跨域后台用CrossOrigin
@CrossOrigin
@RequestMapping("/user")
public class UserApi {

    @Autowired
    UserService userService;

    @RequestMapping("/checkUser")
    public User checkUser(@RequestBody User user) {
        User user1 = userService.checkUser(user);
        user1.setPassword("");
        return user1;
    }

    @RequestMapping("/list")
    public PageInfo<User> list(String username, Integer page, Integer pagesize) {
        return userService.list(username, page, pagesize);
    }

    @RequestMapping("add")
    public void add(@RequestBody User user) {
        userService.add(user);
    }

    @RequestMapping("get/{id}")
    public User get(@PathVariable("id") String id) {
        return userService.get(id);
    }

    @RequestMapping("modify")
    public void modify(@RequestBody User user) {
        userService.modify(user);
    }
}
