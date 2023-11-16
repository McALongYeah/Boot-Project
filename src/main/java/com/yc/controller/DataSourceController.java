package com.yc.controller;

import com.yc.MyConfig;
import com.yc.bean.Product;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController

@Log4j2//lombok注入一个log4j2对象
public class DataSourceController implements ApplicationContextAware {

    //  commons.logging.log
//    private static Log log = LogFactory.getLog(DataSourceController.class);

    @Autowired
//    @Qualifier("myDataSource2")
    private DataSource ds;

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private Product product;

    private ApplicationContext ac;
    @GetMapping("/ds") //
    public String getDsInfo(){
        String[] beannames = this.ac.getBeanDefinitionNames();
        for (String bn : beannames) {
            System.out.println(bn);
        }

        log.info(product.toString());
        log.info(myConfig);
        log.debug("debug调试");
        log.info("info 普通");
        log.warn("warn 警告");
        log.error("error错误");
        log.fatal("fatal致命");
        return ds.toString();
    }
//注入spring 容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }
}
