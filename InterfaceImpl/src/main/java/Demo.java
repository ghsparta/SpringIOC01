import entity.Brake;
import entity.Car;
import entity.Engine;

public class Demo {
    public static void main(String[] args) {
        Car car=new Car(new Engine(),new Brake());
        System.out.println(car);
    }
}
