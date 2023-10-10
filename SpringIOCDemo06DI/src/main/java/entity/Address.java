package entity;

import org.springframework.stereotype.Component;

@Component
public class Address {

    int zipcode;
    String streetname;

    @Override
    public String toString() {
        return "Address{" +
                "zipcode=" + zipcode +
                ", streetname='" + streetname + '\'' +
                '}';
    }
}
