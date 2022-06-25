package com.example.htc.mapper;

import com.example.htc.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public interface DishMapper {

    //获取菜谱
    public Dish getById(int id);

    //获取所有素菜名
    public List<Dish> getAllVegetable();

    //随机获取4个菜谱
    public List<Dish> getFourDish();

    //获取所有汤名
    public List<Dish> getAllSoup();

    //获取所有荤菜名
    public List<Dish> getAllMeat();

    //模糊查询菜谱
    public List<Dish> getFuzzyQuery(String str);

    //随机获取10个菜谱
    public List<Dish> getTenDish();

    //随机获取五个菜谱的图片
    public List<Dish> getFiveImg();

}
