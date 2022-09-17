package entity;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public String brand;
    public float price;

    static{
        System.out.println("static constructor of Car..........");
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "entity.Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
