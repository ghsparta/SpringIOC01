package com.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app =
				new AnnotationConfigApplicationContext(AOPConfig.class);
		Calculator c = app.getBean(Calculator.class);
		for (String beanDefinitionName : app.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		System.out.println(c.getClass().getName());
		int result = c.div(4, 0);
		System.out.println(result);
		app.close();

	}
}