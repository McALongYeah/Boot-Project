package com.yc.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//@Component //IOC
@Data   //lombok
@ConfigurationProperties(prefix = "product")
//DI : 当processer 读取到 application.yml时，里面以product.xxx 开头的配置信息,存到此对象中
public class Product implements Serializable {
    private String pname;
    private Double price;
    private Boolean isUsed;
    private Data manData;
    private Map<String,String> attribute;//键值对
    private Address address;
    private List<String> types;
}
