package entity;

public class PlaneFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle() {
        System.out.println("before plane instantiation............");
        Plane plane = new Plane();
        System.out.println("after plane instantiation............");
        return plane;
    }
}
