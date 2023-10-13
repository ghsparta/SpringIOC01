package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

    Displayer displayer;

    Printer printer;


    @Override
    public String toString() {
        return "Computer{" +
                "displayer=" + displayer +
                ", printer=" + printer +
                '}';
    }

    public Computer(Displayer displayer, Printer printer) {
        this.displayer = displayer;
        this.printer = printer;
    }

    public Computer() {
    }
}
