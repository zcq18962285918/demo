package com.vue.demo.mapper;

import com.vue.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select(value = "select * from product")
    List<Product> list();
}
