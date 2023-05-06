package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Commodity;
import com.example.demo.domain.User;
import com.example.demo.domain.User_log;
import com.example.demo.repository.CommodityDao;
import com.example.demo.service.CommodityService;
import jakarta.annotation.Resource;

public class CommodityServiceImpl implements CommodityService{
    @Resource
    private CommodityDao commodityDao;

    @Override
    public Commodity createCommodity(String name, String price, String description, String number) {
        return null;
    }

    @Override
    public Commodity SetCommodityById(Long id, String name, String price, String description, String number) {
        return null;
    }

    @Override
    public Commodity GetCommodityById(Long id) {
        return null;
    }

    @Override
    public Commodity GetCommodityByName(String name) {
        return null;
    }

    @Override
    public Commodity deleteCommodityById(Long id) {
        return null;
    }

    @Override
    public Commodity BuyCommodityById(Long id, String number, String token) {
        return null;
    }


    @Override
    public Commodity creatPass( Commodity commodity) {
        //返回创建好的商品对象(带uid)
        Commodity newCommodity = commodityDao.save(commodity);
        newCommodity.setCommodity_price("");
        newCommodity.setCommodity_name("");
        newCommodity.setCommodity_description("");
        return newCommodity;
    }


}









