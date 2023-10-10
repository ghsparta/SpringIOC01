package entity;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope
public class Car implements BeanNameAware, BeanFactoryAware, InitializingBean {
    String brand;
    String beanName;
    BeanFactory beanFactory;

    public Car() {
        System.out.println("Car().......");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
        System.out.println("****setBeanFactory()*****");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName=name;
        System.out.println("****setBeanName()*****");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", beanName='" + beanName + '\'' +
                ", beanFactory=" + beanFactory +
                '}';
    }
    @PostConstruct
    public void f(){
        System.out.println("------------PostConstruct-----------------");
    }

    @PreDestroy
    public void g(){
        System.out.println("------------PreDestroy-----------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("------------afterPropertiesSet-----------------");
    }
}
