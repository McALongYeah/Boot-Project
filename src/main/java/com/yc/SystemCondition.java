package com.yc;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SystemCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory bf = context.getBeanFactory(); //spring的beanFactory
        Environment env = context.getEnvironment();//环境类 - 有环境变量
        String os = env.getProperty("os.name");
        if (os.contains("Linux")){
            return true;
        }
        return false;
    }
}
