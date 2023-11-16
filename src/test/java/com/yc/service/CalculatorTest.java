package com.yc.service;

import com.yc.MyApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //让Junit运行Spring环境 获得Spring环境上下文
@SpringBootTest(classes = MyApp.class)//获取Spring boot 启动类 包名正确不用配置
public class CalculatorTest {
    //spring 支持 IOC/DI 控制反转  -》 Calculator 实例化后 存入 spring applicationContext
    //支持 DI
    @Autowired
    private Calculator calculator;

    @Test
   public void add() {
        int x = calculator.add(1,2);
//        System.out.println("x = " + x);

        Assert.assertEquals(3, x);
    }
}