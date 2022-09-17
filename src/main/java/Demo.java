import entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;


//@ComponentScan(basePackages = { "entity" })

public class Demo {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Config.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            System.out.println(name);
        }
        System.out.println("==============================");
        Config config=(Config) applicationContext.getBean(Config.class);
        System.out.println(config.getClass().getName());
        System.out.println(config.getCar()==config.getCar());

        Car car = (Car) applicationContext.getBean(Car.class);
        System.out.println(car.getClass().getName());
    }

}
