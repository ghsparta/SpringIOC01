package aopsolution;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "aopsolution")
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext app =
                new AnnotationConfigApplicationContext(Main.class);
        for (String beanDefinitionName : app.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        RealSubject realSubject = app.getBean(RealSubject.class);
        realSubject.doSomething();
        realSubject.doSomethingElse();


        TimingAspect timingAspect = app.getBean(TimingAspect.class);
        System.out.println(timingAspect.stopWatch.prettyPrint());

        app.close();
    }
}
