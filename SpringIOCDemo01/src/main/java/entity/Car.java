package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    public IEngine engine;
    @Autowired
    public IBrake brake;

//    public Car(IEngine engine,IBrake brake){
//        this.brake=brake;
//        this.engine=engine;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
