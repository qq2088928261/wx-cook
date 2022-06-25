package com.example.htc.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.htc.entity.Dish;
import com.example.htc.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    @Resource
    private DishService dishService;

    //通过id查询菜谱
    @GetMapping("/getcp")
    @ResponseBody
    public JSONObject getById(int id){
        return dishService.getById(id);
    }

    //获取所有菜的名字
    @GetMapping("/getAllDish")
    @ResponseBody
    public List<JSONObject> getAllDish(){
        return dishService.getAllDish();
    }

    //随机获取4个菜谱
    @GetMapping("/getFourDish")
    @ResponseBody
    public List<JSONObject> getFourDish(){
        return dishService.getFourDish();
    }

    //模糊查询菜谱
    @GetMapping("/getFuzzyQuery")
    @ResponseBody
    public List<JSONObject> getFuzzyQuery(String str){
        return dishService.getFuzzyQuery(str);
    }

    //随机获取10个菜谱
    @GetMapping("/getTenDish")
    @ResponseBody
    public List<JSONObject> getTenDish(){
        return dishService.getTenDish();
    }

    //随机获取五个菜谱的图片
    @GetMapping("/getFiveImg")
    @ResponseBody
    public List<Dish> getFiveImg(){
        return dishService.getFiveImg();
    }

    //获取主页数据
    @GetMapping("/getHomePageData")
    @ResponseBody
    public JSONObject getHomePageData(){
        return dishService.getHomePageData();
    }

    //获取收藏的所有菜的菜名
    @GetMapping("/getAllName")
    @ResponseBody
    public List<JSONObject> getAllName(int[] list){

        return dishService.getAllName(list);

    }

}
