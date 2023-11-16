package com.yc;

import com.alibaba.druid.pool.DruidDataSource;
import com.yc.bean.Apple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * full模式: proxyBeanMethods = true 被CGLIB 代理 -> 扩展功能
 * lite模式: proxyBeanMethods = false
 */
@Configuration(proxyBeanMethods = true) //配置类也被spring托管
//@Profile("prod)
public class MyConfig {
    @Value("${yc.driverClassName}")
    private String diverName;
    @Value("${yc.url}")
    private String url;
    @Value("${yc.username}")
    private String username;
    @Value("${yc.password}")
    private String password;

//    @Bean  //id="a"
//    public Apple a(){
//        return new Apple();
//
//    }
    //第三方类，采用@Bean注解托管
    @Bean
    @Profile("test") //只有spring.profiles.active = 'test'这个bean才会被spring 托管
    //@Profile("default)
    public DataSource myDataSource() {
        DriverManagerDataSource ds = (DriverManagerDataSource) new DriverManagerDataSource();
        ds.setDriverClassName(diverName);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }

    @Bean
    @Profile("prod") //它表示指定了spring.profiles.active:"prod的时候用这个数据源
    public DataSource myDataSource2() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(diverName);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);
        return ds;
    }

}


