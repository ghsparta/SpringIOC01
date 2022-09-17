import entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;



@Configuration
@ComponentScan("entity")
public class Demo {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Demo.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            System.out.println(name);
        }
        System.out.println("==============================");


        Car car = (Car) applicationContext.getBean(Car.class);
        System.out.println(car.getClass().getName());
    }

}
