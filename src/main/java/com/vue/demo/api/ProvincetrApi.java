package com.vue.demo.api;

import com.vue.demo.entity.Provincetr;
import com.vue.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("province")
public class ProvincetrApi {

    @Autowired
    ProvinceService provinceService;

    @RequestMapping("/list")
    public List<Provincetr> list(){
        return provinceService.list();
    }
}
