package entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Factory {

    @Bean
    public Car getCar(){
        return new Car();
    }
}
