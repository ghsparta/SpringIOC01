import entity.Person;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("entity")
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(applicationContext.getBeanDefinition("car"));


        RootBeanDefinition rootBeanDefinition=new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(Person.class);
        applicationContext.registerBeanDefinition("man",rootBeanDefinition);

        System.out.println("======================");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(applicationContext.getBean("man"));
        System.out.println("======================");

        applicationContext.getBeanFactory().registerSingleton("sman",new Person("superman",100));
        System.out.println(applicationContext.getBean("sman"));
    }
}
