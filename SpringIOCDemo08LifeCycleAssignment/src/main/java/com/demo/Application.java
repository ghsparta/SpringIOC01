package com.demo;

import com.demo.config.AppConfig;
import com.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        UserService userService = context.getBean(UserService.class);
        userService.displayUser();
        context.close();
    }
}
