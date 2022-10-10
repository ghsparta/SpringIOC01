package com.demo.aop;
 
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
 
//日志切面类
@Aspect
public class LogAspects {
	@Pointcut("execution(public int com.demo.aop.Calculator.*(..))")
	public void pointCut(){};
	
	//@before代表在目标方法执行前切入, 并指定在哪个方法前切入
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		int i = (int) joinPoint.getArgs()[0];
		int j = (int) joinPoint.getArgs()[1];

		System.out.println(String.format("除法运行....参数列表是:{%s,%s}",i,j));
	}
	@After("pointCut()")
	public void logEnd(){
		System.out.println("除法结束......");
	}
	@AfterReturning(value = "pointCut()",returning = "retval")
	public void logReturn(Object retval){
		System.out.println(retval);
		System.out.println("除法正常返回......运行结果是:{}");
	}
	@AfterThrowing(value = "pointCut()",throwing = "e")
	public void logException(Exception e){
		System.out.println(e.getMessage());
		System.out.println("运行异常......异常信息是:{}");
	}
	@Around("pointCut()")
	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{


		System.out.println("@Arount:执行目标方法之前...");
		Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
		System.out.println("@Arount:执行目标方法之后...");
		return obj;


	}
}