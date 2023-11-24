package aopsolution;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class RetryAspect {
    @Value("30")
    int RetryTimes;

    @Pointcut("@annotation(aopsolution.Retry)")
    public void pointcut() {

    }



    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        for (int i = 0; i < RetryTimes; i++) {
            try {
                System.out.println("Retry for the " + (i+1) + " time");
                return joinPoint.proceed();
            } catch (Throwable e) {
                System.err.println("Failed for the " + (i+1) + " time");
//                e.printStackTrace();
            }
        }

        return null;

    }
}
