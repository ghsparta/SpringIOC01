package com.demo.model;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("specialuser")
public class User implements BeanNameAware, BeanFactoryAware, InitializingBean {
    @Value("${thisuser.name}")
    private String name;

    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public User() {
        System.out.println("User构造方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public String getName() {
        return name;
    }

    @Override
    public void afterPropertiesSet() {
        // 使用BeanFactory去查询系统中的bean数量，为了模拟做实际工作
        if (beanFactory instanceof ListableBeanFactory) {
            int beanCount = ((ListableBeanFactory) beanFactory).getBeanDefinitionCount();
            System.out.println("系统中的Bean数量: " + beanCount);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("User初始化: " + name);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("User销毁");
    }
}
