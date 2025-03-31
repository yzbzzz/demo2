package com.example.Commodity.controller;


import com.example.Commodity.domain.Commodity;
import com.example.Commodity.service.CommodityService;
import com.example.Commodity.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commodity")

public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @PostMapping("/creatCommodity")
    public Result<Commodity> addController(@RequestParam String name, @RequestParam String price, @RequestParam String description, @RequestParam String number ){
        Commodity commodity = commodityService.createCommodity(name,price,description,number);
        if (commodity!= null){
            return Result.success(commodity,"添加成功");
        }
            else{
            return Result.error("500","添加失败");
            }

        }
    }




