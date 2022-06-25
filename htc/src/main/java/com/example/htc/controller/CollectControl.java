package com.example.htc.controller;

import com.example.htc.entity.collect;
import com.example.htc.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
    public class CollectControl {
    @Autowired
    private CollectService collectService;

    @GetMapping("/collection")
    public int register(collect dish){
        return  collectService.register(dish);
    }
    @GetMapping("/delete")
    public int delete(collect dishid){return  collectService.delete(dishid);}
    @GetMapping("/findbyid")
    public boolean findid(collect dish){return collectService.find(dish);}
    @GetMapping("/getdishid")
    public List<Integer> getdishid(@RequestParam("username") String dishid){return collectService.getdishid(dishid);}

}