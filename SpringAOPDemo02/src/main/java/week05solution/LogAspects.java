package week05solution;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.StopWatch;

//日志切面类
@Aspect
public class LogAspects {
//	@Pointcut("execution(public int aop.Calculator.*(..))")
//	public void pointCut(){};
//
//	//@before代表在目标方法执行前切入, 并指定在哪个方法前切入
//	@Before("pointCut()")
//	public void logStart(JoinPoint joinPoint){
//		int i = (int) joinPoint.getArgs()[0];
//		int j = (int) joinPoint.getArgs()[1];
//
//		System.out.println(String.format("除法运行....参数列表是:{%s,%s}",i,j));
//	}
//	@After("pointCut()")
//	public void logEnd(){
//		System.out.println("除法结束......");
//	}
//	@AfterReturning(value = "pointCut()",returning = "retval")
//	public void logReturn(Object retval){
//		System.out.println(retval);
//		System.out.println("除法正常返回......运行结果是:{}");
//	}
//	@AfterThrowing(value = "pointCut()",throwing = "e")
//	public void logException(Exception e){
//		System.out.println(e.getMessage());
//		System.out.println("运行异常......异常信息是:{}");
//	}
//	@Around("pointCut()")
//	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//
//		System.out.println("@Arount:执行目标方法之前...");
//		Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
//		System.out.println("@Arount:执行目标方法之后...");
//		return obj;
//
//
//	}
	@Around("@annotation(week05solution.TimeRecording)")
	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

		String classname = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
		String methodname = proceedingJoinPoint.getSignature().getName();

		StopWatch stopWatch=new StopWatch("Time consuming.......");
		stopWatch.start(classname+"---->"+methodname);

		Object obj = proceedingJoinPoint.proceed();//相当于开始调div地

		stopWatch.stop();

		System.out.println(stopWatch.prettyPrint());

		return obj;


	}
}