package com.yc.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int add(int x, int y){
        return x+y;
    }
}
