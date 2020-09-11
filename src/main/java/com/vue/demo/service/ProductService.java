package com.vue.demo.service;

import com.vue.demo.entity.Product;
import com.vue.demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<Product> list() {
        return productMapper.list();
    }
}
