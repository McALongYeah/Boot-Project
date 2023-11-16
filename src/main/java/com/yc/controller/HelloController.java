package com.yc.controller;

//web的controller  spring MVC


import com.yc.MyApp;
import com.yc.bean.Student;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RestController // 表示这个控制器符合rest 规范 （允许GET,POST,PUT,DELETE）  响应结果为json
@Slf4j
public class HelloController {
    @Value("${yc.driverClassName}")
    private String diverName;
    @Value("${yc.url}")
    private String url;
    @Value("${yc.username}")
    private String username;
    @Value("${yc.password}")
    private String password;

    @Autowired
    @Qualifier(value = "s")
    private Student student;

    @Autowired //spring 启动时 自动加载
    private Environment env;
    @Resource
    private ConfigurableEnvironment springEnv;


    @RequestMapping("/")
    public String home(){
        String result = "Hello World!";
        result += "\nurl=" + url + "\nusername=" + username + "\npassword=" + password;
        result += "\nsid=" + student.getSid() + "\tname=" + student.getName();

        result += "\n" + springEnv.getProperty("user.home") + "\t jdk:" +
                springEnv.getProperty("JAVA_HOME");
        return result ;
    }

    /**
     *
     * @param type
     * @return
     * SpringMVC 中如何传参
     * 1.返回时间
     * 2.返回随机数
     */
    @RequestMapping(value = "/service",method = {RequestMethod.POST,RequestMethod.GET})
    public String service(@RequestParam(required = false) Integer type){
        if (type == null){
            return "参数无效！";
        }
        if (type == 1){
            return new Date() + "";
        }
        if (type == 2){
            return new Random().nextInt() + "";
        }
     return "没有该参数！";
    }

    //需求： 注册一个学生名 我返回一个学生对象的信息
    @RequestMapping(value = "/reg" , method = RequestMethod.POST)
    public Student reg(@RequestParam String name){
        Student s = new Student();
        s.setSid(new Random().nextInt());
        s.setName(name);
        return s;
    }

    //需求： 注册一个学生名 我返回一个学生对象的信息
    @RequestMapping(value = "/reg2" , method = RequestMethod.POST)
    public Student reg2(Student s){
        log.info("你访问reg2");
        s.setSid(new Random().nextInt());
        return s;
    }
}
