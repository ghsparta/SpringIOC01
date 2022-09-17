package entity;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class Car {
    public String Brand;
    public int Price;


}
