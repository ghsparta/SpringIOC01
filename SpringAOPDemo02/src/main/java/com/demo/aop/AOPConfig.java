package com.demo.aop;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
 
import com.demo.aop.Calculator;
import com.demo.aop.LogAspects;
 
@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {
	@Bean
	public Calculator calculator(){
		return new Calculator();
	}


	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}

