import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("entity")
public class Demo {
    public static void main(String[] args) throws Exception{

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);

        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(applicationContext.getBean("car"));
    }
}
