import entity.VehicleFactory;
import entity.VehicleFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan("entity")
public class FactoryMethodDemo {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryMethodDemo.class);
        VehicleFactoryBuilder vehicleFactoryBuilder = (VehicleFactoryBuilder) applicationContext.getBean("vehicleFactoryBuilder");
        System.out.println(vehicleFactoryBuilder.getVehicleFactory().getVehicle());
    }
}
