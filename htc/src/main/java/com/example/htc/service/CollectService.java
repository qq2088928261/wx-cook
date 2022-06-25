package com.example.htc.service;

import com.example.htc.entity.collect;
import com.example.htc.mapper.collectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectService {
    @Resource
    private collectMapper collectMapper;
    public int register(collect dish) {
        if(dish.getUsername().equals("")){
            return  0;
        }
        return collectMapper.insertCollection(dish);
    }
    public int delete(collect dishid) {return collectMapper.deleteCollection(dishid);}
    public boolean find(collect dish) {
        if(collectMapper.findid(dish)!=null)
        {
            return true;
        }else
            return false;
    }
    public List<Integer> getdishid(String dishid){return collectMapper.getdishid(dishid);}
}
