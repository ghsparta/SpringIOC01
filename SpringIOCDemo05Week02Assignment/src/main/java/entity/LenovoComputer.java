package entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LenovoComputer extends Computer{



    //@Autowired
    public void setDisplayer(Displayer dellDisplayerFactoryBean){
        this.displayer=dellDisplayerFactoryBean;
//        System.out.println("");
    }

    @Autowired
    public void setPrinter(Printer hpPrinter){
        this.printer=hpPrinter;
    }

    public LenovoComputer(Displayer dellDisplayerFactoryBean, Printer hpPrinter) {
        super(dellDisplayerFactoryBean, hpPrinter);
//        this.displayer = dellDisplayerFactoryBean;
//        this.printer = hpPrinter;
    }


}
