package entity;

import entity.Car;
import entity.Plane;
import entity.Vehicle;

public class SimpleFactory {
    public Vehicle getVehicle(String vtype){
        switch (vtype){
            case "car":
                return new Car();
            case "plane":
                return new Plane();
        }
        return null;
    }
}
