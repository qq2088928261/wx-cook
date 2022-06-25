package com.example.htc.service;

import com.alibaba.fastjson.JSONObject;
import com.example.htc.entity.Dish;
import com.example.htc.mapper.DishMapper;
import com.example.htc.utils.DataConversion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    @Resource
    private DishMapper dishMapper;

    //通过id查询菜谱
    public JSONObject getById(int id){

        return DataConversion.dishDataConversion(dishMapper.getById(id));

    }

    //获取所有菜的名字
    public List<JSONObject> getAllDish(){

        List<Dish> list1 = dishMapper.getAllVegetable();
        List<Dish> list2 = dishMapper.getAllMeat();
        List<Dish> list3 = dishMapper.getAllSoup();

        JSONObject jsonObject1 = DataConversion.dataCon(list1,"素菜");
        JSONObject jsonObject2 = DataConversion.dataCon(list2,"荤菜");
        JSONObject jsonObject3 = DataConversion.dataCon(list3,"汤");

        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();

        jsonObjectArrayList.add(jsonObject1);
        jsonObjectArrayList.add(jsonObject2);
        jsonObjectArrayList.add(jsonObject3);

        return jsonObjectArrayList;
    }

    //主页数据

    //随机获取4个菜谱
    public List<JSONObject> getFourDish(){
        return DataConversion.dishesDataConversion(dishMapper.getFourDish());
    }


    //模糊查询菜谱
    public List<JSONObject> getFuzzyQuery(String str){
        return DataConversion.dishesDataConversion(dishMapper.getFuzzyQuery(str));
    }

    //获取10个菜谱
    public List<JSONObject> getTenDish(){
        return DataConversion.dishesDataConversion(dishMapper.getTenDish());
    }

    //随机获取五个菜谱的图片
    public List<Dish> getFiveImg(){
        return dishMapper.getFiveImg();
    }

    //获取主页数据
    public JSONObject getHomePageData(){
        return DataConversion.homeDataConversion(dishMapper.getFiveImg(),dishMapper.getFourDish(),dishMapper.getTenDish());
    }

    //获取收藏的所有菜的菜名
    public List<JSONObject> getAllName(int[] list){

        List<Dish> arrayList = new ArrayList<Dish>();

        for (int i : list){

            arrayList.add(dishMapper.getById(i));

        }

        return DataConversion.CollectionDataConversion(arrayList);

    }

}
