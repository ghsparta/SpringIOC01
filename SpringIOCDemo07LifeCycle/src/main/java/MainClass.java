import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("entity")
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainClass.class);
        System.out.println(applicationContext.getBeanDefinition("car"));
        System.out.println(applicationContext.getBean("car"));
        applicationContext.close();

    }
}
