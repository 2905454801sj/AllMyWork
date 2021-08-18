package com.o.AutoProxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//切面类中确定通知，需要实现不同的接口，接口就是规范，从而确定方法名称
//采用环绕通知 methodinterceptor
public class MyAspect2 implements MethodInterceptor {
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// 手动执行目标方法
		System.out.println("前");
		Object object = methodInvocation.proceed();
		System.out.println("后");
		return object;
	}

	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
}
