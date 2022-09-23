package entity;

public class BikeFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle() {
        System.out.println("before car instantiation............");
        Bike car = new Bike();
        System.out.println("after car instantiation............");
        return car;
    }
}