package com.example.demo.controller;


import com.example.demo.domain.Commodity;
import com.example.demo.service.CommodityService;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @PostMapping("/creatCommodity")
    public Result<Commodity> addController(@RequestParam String name, @RequestParam String price,@RequestParam String description, @RequestParam String number ){
        Commodity commodity = commodityService.createCommodity(name,price,description,number);
        if (commodity!= null){
            return Result.success(commodity,"添加成功");
        }
            else{
            return Result.error("500","添加失败");
            }

        }
    }




