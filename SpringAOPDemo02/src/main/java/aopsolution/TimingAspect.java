package aopsolution;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Order(1)
public class TimingAspect {
    public StopWatch stopWatch = new StopWatch("My StopWatch");
    @Pointcut("@annotation(aopsolution.Timing)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try{
            String classname = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
            String methodname = proceedingJoinPoint.getSignature().getName();
            stopWatch.start(classname+"----->"+methodname);
            Object obj = proceedingJoinPoint.proceed();


            return obj;
        }catch (Exception e){
//            e.printStackTrace();
            throw e;
        }finally {
            stopWatch.stop();
        }


    }
}
