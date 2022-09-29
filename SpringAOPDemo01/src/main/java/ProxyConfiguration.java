import entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods=true)
@ComponentScan("entity")
public class ProxyConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ProxyConfiguration.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {

            System.out.println(beanDefinitionName);
        }

        ProxyConfiguration proxyConfiguration =
                (ProxyConfiguration) applicationContext.getBean("proxyConfiguration");

        System.out.println(proxyConfiguration.getClass().getName());


        System.out.println(proxyConfiguration.getCar() == proxyConfiguration.getCar());

        ProxyConfiguration proxyConfiguration1 = new ProxyConfiguration();

        System.out.println(proxyConfiguration1.getCar() == proxyConfiguration1.getCar());

    }



    @Bean
    public Car getCar(){
        return new Car();
    }

}
