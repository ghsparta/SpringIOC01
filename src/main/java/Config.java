import entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class Config {
    @Bean()
    public Car getCar(){
        return new Car();
    }
}
