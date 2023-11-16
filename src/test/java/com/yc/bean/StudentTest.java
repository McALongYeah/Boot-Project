package com.yc.bean;

import com.yc.MyApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //让Junit运行Spring环境 获得Spring环境上下文
@SpringBootTest(classes = MyApp.class) //获取Spring boot 启动类 包名正确不用配置
public class StudentTest {
    @Autowired
    private Student student;

    @Test
    public void testHello(){
        student.setName("hello");
        Assert.assertNotNull(student);
    }
}