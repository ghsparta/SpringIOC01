import entity.Car;
import entity.Door;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan("entity")
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainClass.class);
        System.out.println(applicationContext.getBeanDefinition("car"));
        Car car = (Car) applicationContext.getBean("car");
        System.out.println("======doorList========");
        for(Door door:car.doorList){
            System.out.println(door);
        }
        System.out.println("======doorSet========");
        for(Door door:car.doorSet){
            System.out.println(door);
        }
        System.out.println("======doorArray========");
        for(Door door:car.doorArray){
            System.out.println(door);
        }
        System.out.println("=======doorMap=======");
        for(Map.Entry<String, Door> entry:car.doorMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println();

    }
}
