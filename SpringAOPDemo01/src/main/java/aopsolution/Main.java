package aopsolution;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aopsolution")
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        RealSubject realSubject = (RealSubject) context.getBean("realSubject");
        realSubject.doSomething();
        realSubject.doSomethingElse();

        TimingAspect timingAspect = (TimingAspect) context.getBean("timingAspect");
        System.out.println(timingAspect.stopWatch.prettyPrint());
        context.close();
    }
}
