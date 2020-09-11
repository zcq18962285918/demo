package com.vue.demo.api;


import com.vue.demo.entity.Product;
import com.vue.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductApi {

    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    public List<Product> list() {
        return productService.list();
    }
}
