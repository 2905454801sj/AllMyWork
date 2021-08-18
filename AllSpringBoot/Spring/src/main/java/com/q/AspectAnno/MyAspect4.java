package com.q.AspectAnno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面类，含多个通知
@Component("myaspectid")
@Aspect
public class MyAspect4 {
	//切入点当前有效
	@org.aspectj.lang.annotation.Before("execution(* com.q.AspectAnno.UserServiceImpl4.*(..))")
	public void Before(JoinPoint joinPoint) {
		System.out.println("前置通知：	"+joinPoint.getSignature().getName());
	}
	
	
	//声明公共的切入点表达式，方法名等于ID
	@Pointcut("execution(* com.q.AspectAnno.UserServiceImpl4.*(..))")
	private void myPointcut() {
		
	}
	@org.aspectj.lang.annotation.AfterReturning(value="myPointcut()",returning="object")
	public void AfterReturning(JoinPoint joinPoint,Object object) {
		System.out.println("后置通知：	"+joinPoint.getSignature().getName()+"---->"+object);
	}
	
	
	@org.aspectj.lang.annotation.Around(value="myPointcut()")
	public Object Around(ProceedingJoinPoint point)throws Throwable {
		//手动执行目标方法
		System.out.println("前.环绕通知");
		Object object=point.proceed();
		System.out.println("后.环绕通知");
		return object;
	}
	
	
	@org.aspectj.lang.annotation.AfterThrowing(value="myPointcut()",throwing="e")
	public void AfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("抛出异常通知：	"+e.getMessage());
	}
	
	
	@org.aspectj.lang.annotation.After("myPointcut()")
	public void After(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
}
