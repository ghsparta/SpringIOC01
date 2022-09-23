package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class Car {

    @Value("Audi")
    public String brand;


    public int price;

    @Autowired
    public List<Door> doorList;

    @Autowired
    public Set<Door> doorSet;

    @Autowired
    public Door[] doorArray;

    @Autowired
    public Map<String,Door> doorMap;


//   @Resource(name = "myengine")
    Engine engine;

    @Autowired
    public Car(@Value("BMW")String brand, @Value("321")int price, Engine engine) {
        this.brand = brand;
        this.price = price;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                '}';
    }
}
