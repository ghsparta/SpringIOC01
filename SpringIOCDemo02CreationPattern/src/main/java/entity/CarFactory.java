package entity;

public class CarFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle() {
        System.out.println("before car instantiation............");
        Car car = new Car();
        System.out.println("after car instantiation............");
        return car;
    }
}
