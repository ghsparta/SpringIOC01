import entity.SimpleFactory;
import entity.Vehicle;

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Vehicle v = new SimpleFactory().getVehicle("car");
        System.out.println(v);
        v = new SimpleFactory().getVehicle("plane");
        System.out.println(v);
    }
}
