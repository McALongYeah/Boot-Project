package com.yc.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data//get set 方法
@Component //被spring 托管
public class Student implements Serializable {
    private Integer sid;
    private String name;
}

//Student.java类  -> Student.class字节码 加入get set equals 方法

//javac时  @Data 根据属性生成 set get


/**
 * //注解保留时间点
 * java 源代码  @Retention(RetentionPolicy.SOURCE) lombok插件
 * class 字节码
 * jvm中运行期 runtime Controller ->@Retention(RetentionPolicy.RUNTIME) 运行时起作用
 */