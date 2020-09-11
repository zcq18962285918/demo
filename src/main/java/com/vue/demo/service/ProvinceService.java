package com.vue.demo.service;

import com.vue.demo.entity.Provincetr;
import com.vue.demo.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    ProvinceMapper provinceMapper;

    public List<Provincetr> list() {
        /**
         * // 所有最顶父级
         *         List<Provincetr> provinceList = provinceMapper.list(0);
         *
         *         // 遍历
         *         provinceList.forEach(provincetr -> {
         *             // 根据父级id查询子级
         *             List<Provincetr> provincetrs = provinceMapper.list(provincetr.getId());
         *             // 递归调用
         *             listAll(provinceList);
         *             // 调用完毕后，把子集设置给父级
         *             provincetr.setChildren(provincetrs);
         *         });
         */

        List<Provincetr> provinceList = provinceMapper.list(0);
        provinceList.forEach(provincetr -> {
            List<Provincetr> cityList = provinceMapper.list(provincetr.getId());
            provincetr.setChildren(cityList);
            cityList.forEach(provincetr1 -> {
                List<Provincetr> citys = provinceMapper.list(provincetr1.getId());
                provincetr1.setChildren(citys);
            });
        });



        return provinceList;
    }

    private void listAll(List<Provincetr> provincetrList) {
        if (provincetrList.size() != 0) {
            provincetrList.forEach(provincetr -> {
                System.out.println(provincetr.getId());
                List<Provincetr> provincetrs = provinceMapper.list(provincetr.getId());
                if (provincetrs.size() > 0) {
                    provincetr.setChildren(provincetrs);
                    listAll(provincetrs);
                }
            });
        }

    }
}
