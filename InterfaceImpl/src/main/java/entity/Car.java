package entity;

public class Car {
    public IEngine engine;
    public IBrake brake;


    public Car(IEngine engine,IBrake brake){
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
