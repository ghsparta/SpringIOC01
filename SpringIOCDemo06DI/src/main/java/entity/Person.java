package entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Person {
    /** control flow for di
     * 1.@Autowired on constructors and @Value @Autowired on parameters
     * 2.@Value @Autowired on attributes
     * 3.@Autowired on setters
     *
     */
    int pid;
    @Value("zhangsan")
    String pname;


    Address address;


    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Autowired
    public void setPname(@Value("lisi") String pname) {
        System.out.println("before setting======="+this.pname);
        this.pname = pname;
        System.out.println("after setting======="+this.pname);
    }

    public Person() {
        System.out.println("in person constructor person()");
    }

    @Autowired
    public Person(@Value("123") int pid, @Value("wangwu") String pname) {
        System.out.println("in person constructor person(int pid, String pname)");
        this.pid = pid;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", address=" + address +
                '}';
    }
}

