package entity;

import java.io.ObjectInputFilter;

public class Car {
    public Engine engine;
    public Brake brake;

    public Car(Engine engine,Brake brake){
        this.brake=brake;
        this.engine=engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
