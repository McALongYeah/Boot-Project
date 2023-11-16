package com.yc.bean;

import com.yc.SystemCondition;
import org.springframework.context.annotation.Conditional;

@Conditional(SystemCondition.class)
public class Apple {
    public Apple(){
        System.out.println("这是一个第三方jar包中的类");
    }
}
