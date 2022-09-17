package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    public String pname;
    public int age;


}
