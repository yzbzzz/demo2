package com.example.demo.service;

import com.example.demo.domain.Commodity;

public interface CommodityService {


    /**
     * 创建商品逻辑
     * @param name 商品名
     * @param price 商品价格
     * @param description 商品描述
     * @param number 商品价格
     */


    Commodity addCommodity(String name, String price, String description, String number);
    /**
     * 编辑商品逻辑
     * @param name 商品名
     * @param price 商品价格
     * @param description 商品描述
     * @param number 商品库存
     */

    Commodity SetCommodityById(Long id, String name, String price, String description, String number);


    /**
     * 通过ID查找商品逻辑
     * @param id 商品id
     */



    Commodity GetCommodityById(Long id);

    Commodity GetCommodityByName(String name);


    Commodity deleteCommodityById(Long id);


    Commodity BuyCommodityById(Long id, String number, String token);







}
