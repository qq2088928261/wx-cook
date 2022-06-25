package com.example.htc;

import com.example.htc.mapper.DishMapper;
import com.example.htc.utils.DataConversion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    DishMapper dishMapper;

    @Test
    void contextLoads() {


    }

//    @Test
//    public void getAll(){
//        System.out.println(DataConversion.dataCon(vegetableMapper.getAllVegetable()));
//    }

    @Test
    public void getFourDish(){
        System.out.println(DataConversion.dishesDataConversion(dishMapper.getFourDish()));
    }


}
