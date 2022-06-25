package com.example.htc.mapper;

import com.example.htc.entity.collect;

import java.util.List;

public interface collectMapper {
    //增加收藏
    public int insertCollection(collect dish);
    //删除收藏
    public int deleteCollection(collect dishid);
    //获取收藏
    //public int getCollection(collect dishid);
    //查找收藏
    public collect findid(collect dishid);
    //获取收藏
    public List<Integer> getdishid(String dishid);

}
