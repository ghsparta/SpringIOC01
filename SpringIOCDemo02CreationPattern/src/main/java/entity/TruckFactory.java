package entity;

public class TruckFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle() {
        System.out.println("before Truck instantiation............");
        Truck car = new Truck();
        System.out.println("after Truck instantiation............");
        return car;
    }
}
