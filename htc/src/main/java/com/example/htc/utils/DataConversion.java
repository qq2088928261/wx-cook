package com.example.htc.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.htc.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public class DataConversion {


    //处理所有菜名，把数据封装成前端可用的数据
    public static JSONObject dataCon(List<Dish> list,String type){

        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();



        for (int i=0;i<list.size();i++){

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("text",list.get(i).getDishName());

            jsonObject.put("id",list.get(i).getId());

            jsonObjectList.add(jsonObject);



        }

        JSONObject jsonObject1 = new JSONObject();

        jsonObject1.put("text",type);
        jsonObject1.put("dot",true);
        jsonObject1.put("disabled",false);
        jsonObject1.put("children",jsonObjectList);

        return jsonObject1;

    }


    //处理多个菜谱数据
    public static List<JSONObject> dishesDataConversion(List<Dish> list){





        List<JSONObject> jsonObjectList = new ArrayList<>();

        for (int i = 0; i<list.size();i++){

            JSONObject jsonObject = new JSONObject();
            List<String> stringList1 = new ArrayList<>();
            List<String> stringList2 = new ArrayList<>();
            List<String> stringList3 = new ArrayList<>();
            List<String> stringList4 = new ArrayList<>();
            jsonObject.put("id",list.get(i).getId());
            jsonObject.put("dishName",list.get(i).getDishName());
            for(String j : list.get(i).getRame().split("[,]")){
                if (!j.equals("")){
                    stringList1.add(j);
                }
            }
            jsonObject.put("rame",stringList1);
            for(String j : list.get(i).getCal().split("[{}]")){
                if (!j.equals("")){
                    stringList2.add(j);
                }
            }
            jsonObject.put("cal",stringList2);
            for(String j : list.get(i).getOper().split("[{}]")){
                if (!j.equals("")){
                    stringList3.add(j);
                }
            }
            jsonObject.put("oper",stringList3);
            for(String j : list.get(i).getAddcon().split("[{}]")){
                if (!j.equals("")){
                    stringList4.add(j);
                }
            }
            jsonObject.put("addcon",stringList4);
            jsonObjectList.add(jsonObject);
        }
        return jsonObjectList;
    }

    //处理单一菜谱数据
    public static JSONObject dishDataConversion(Dish dish){

        JSONObject jsonObject = new JSONObject();
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        List<String> stringList3 = new ArrayList<>();
        List<String> stringList4 = new ArrayList<>();
        jsonObject.put("id",dish.getId());
        jsonObject.put("dishName",dish.getDishName());
        for(String j : dish.getRame().split("[,]")){
            if (!j.equals("")){
                stringList1.add(j);
            }
        }
        jsonObject.put("rame",stringList1);
        for(String j : dish.getCal().split("[{}]")){
            if (!j.equals("")){
                stringList2.add(j);
            }
        }
        jsonObject.put("cal",stringList2);
        for(String j : dish.getOper().split("[{}]")){
            if (!j.equals("")){
                stringList3.add(j);
            }
        }
        jsonObject.put("oper",stringList3);
        for(String j : dish.getAddcon().split("[{}]")){
            if (!j.equals("")){
                stringList4.add(j);
            }
        }
        jsonObject.put("addcon",stringList4);

        return jsonObject;
    }

    //主页数据
    public static JSONObject homeDataConversion(List<Dish> list1,List<Dish> list2,List<Dish> list3) {

        JSONObject object = new JSONObject();
        List<JSONObject> jsonObjectList1 = new ArrayList<>();
        List<JSONObject> jsonObjectList2 = new ArrayList<>();
        List<JSONObject> jsonObjectList3 = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", list1.get(i).getId());
            jsonObject.put("src", list1.get(i).getImg());
            jsonObjectList1.add(jsonObject);

        }

        for (int i = 0; i < list2.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", list2.get(i).getId());
            jsonObject.put("name", list2.get(i).getDishName());
            jsonObject.put("src", list2.get(i).getImg());
            jsonObjectList2.add(jsonObject);

        }

        for (int i = 0; i < list3.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", list3.get(i).getId());
            jsonObject.put("name", list3.get(i).getDishName());
            jsonObject.put("src", list3.get(i).getImg());
            jsonObjectList3.add(jsonObject);

        }

        object.put("imgUrl", jsonObjectList1);
        object.put("recommendation", jsonObjectList2);
        object.put("caipu", jsonObjectList3);

        return object;

    }

    //
    public static List<JSONObject> CollectionDataConversion(List<Dish> list){

        List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();

        for (int i = 0; i < list.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", list.get(i).getId());
            jsonObject.put("name", list.get(i).getDishName());
            jsonObject.put("src", list.get(i).getImg());
            jsonObjectList.add(jsonObject);

        }

        return jsonObjectList;

    }

}
