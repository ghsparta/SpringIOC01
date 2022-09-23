package entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrinterFactory {

    @Bean("epsonPrinter")
    public Printer getEpsonPrinter(){
        return new EpsonPrinter();
    }
    @Bean("hpPrinter")
    public Printer getHPPrinter(){
        return new HPPrinter();
    }
}
