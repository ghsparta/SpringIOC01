import entity.Car;
import entity.GenericFactoryBean;
import entity.Person;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("entity")

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainClass.class);


        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(applicationContext.getBean("lenovoComputer"));


        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(GenericFactoryBean.class);
        rootBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(Car.class);

        applicationContext.registerBeanDefinition("GenericFactoryBean1",rootBeanDefinition);


        System.out.println(applicationContext.getBean("GenericFactoryBean1"));


        RootBeanDefinition rootBeanDefinition2 = new RootBeanDefinition();
        rootBeanDefinition2.setBeanClass(GenericFactoryBean.class);
        rootBeanDefinition2.getConstructorArgumentValues().addGenericArgumentValue(Person.class);

        applicationContext.registerBeanDefinition("GenericFactoryBean2",rootBeanDefinition2);


        System.out.println(applicationContext.getBean("GenericFactoryBean2"));
    }


}
