package aopsolution;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Order(1)
public class TimingAspect {
    public StopWatch stopWatch=new StopWatch("My StopWatch");

    @Pointcut("@annotation(aopsolution.Timing)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        try{
            String classname = joinPoint.getSignature().getDeclaringType().getSimpleName();
            String methodname = joinPoint.getSignature().getName();

            stopWatch.start(classname+"--->"+methodname);
            return joinPoint.proceed();

        }catch (Throwable e) {
//            throw new RuntimeException(e);
//            e.printStackTrace();
            throw e;
        } finally {
            stopWatch.stop();
        }


//        return null;
    }


}
