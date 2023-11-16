package com.yc;

import com.yc.bean.Apple;
import com.yc.bean.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//自动扫描 该目录和下一级目录
@SpringBootApplication
@PropertySource(value = {"classpath:db.properties"}) //map 键值对
@ImportResource(locations = {"classpath:spring.xml"})

@EnableConfigurationProperties(Product.class)
//id=""com.yc.bean.Apple
@Import({Apple.class,MyFruits.class}) //相当于在Apple类中加入@Component | 相当于@Configuration类中加入@Bean
public class MyApp {
    public static void main(String[] args) {
        if (args != null) {
            for (String s : args) {
                System.out.println(s);
            }
        }
        SpringApplication.run(MyApp.class,args);
    }
}

//tomcat spring 容器 WebapplicationContext 初始化


// -》jar 包 以java独立进程形式运行(java -> jar) -> 一个进程
