import entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods=true)
@ComponentScan("entity")
public class IOCProxy {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(IOCProxy.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(applicationContext.getBean("IOCProxy").getClass());
        IOCProxy iocProxy = (IOCProxy) applicationContext.getBean("IOCProxy");
        System.out.println(iocProxy.getCar() == iocProxy.getCar());
        IOCProxy iocProxy1 = new IOCProxy();
        System.out.println(iocProxy1.getCar() == iocProxy1.getCar());
    }
    @Bean
    public Car getCar(){
        return new Car();
    }
}
