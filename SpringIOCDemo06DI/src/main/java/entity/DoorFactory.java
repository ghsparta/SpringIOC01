package entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class DoorFactory {
    @Bean("door1")
    @Order(2)
    public Door getDoor1(){
        return new Door("door1");
    }
    @Bean("door2")
    @Order(1)
    public Door getDoor2(){
        return new Door("door2");
    }
    @Bean("door3")
    @Conditional(MyCondition.class)
    @Order(3)
    public Door getDoor3(){
        return new Door("door3");
    }
}
class MyCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //context.getBeanFactory().



        return false;
    }
}





















