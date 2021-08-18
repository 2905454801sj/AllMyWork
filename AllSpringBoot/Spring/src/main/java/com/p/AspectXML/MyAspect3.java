package com.p.AspectXML;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//切面类，含多个通知
public class MyAspect3 {
	
	public void Before(JoinPoint joinPoint) {
		System.out.println("前置通知：	"+joinPoint.getSignature().getName());
	}
	public void AfterReturning(JoinPoint joinPoint,Object object) {
		System.out.println("后置通知：	"+joinPoint.getSignature().getName()+"---->"+object);
	}
	public Object Around(ProceedingJoinPoint point)throws Throwable {
		//手动执行目标方法
		System.out.println("前.环绕通知");
		Object object=point.proceed();
		System.out.println("后.环绕通知");
		return object;
	}
	public void AfterThrowing(JoinPoint joinPoint,Throwable e) {
		System.out.println("抛出异常通知：	"+e.getMessage());
	}
	public void After(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
}
