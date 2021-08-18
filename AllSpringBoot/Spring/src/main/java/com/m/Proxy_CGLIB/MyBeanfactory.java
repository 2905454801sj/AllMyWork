package com.m.Proxy_CGLIB;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyBeanfactory {
	
	public static UserServiceImpl createUser() {
		//目标类
		final UserServiceImpl userService =new UserServiceImpl();
		//切面类
		final MyAspect myAspect=new MyAspect();
		//采用cglib，底层创建目标类的子类 
		//核心类
		Enhancer enhancer=new Enhancer();
		//确定父类
		enhancer.setSuperclass(userService.getClass());
		/*//设置回调函数,MethodIntweceptor等效于JDK中的 invokehandler
		intercept等效于invoke
		参数1，2,3与invoke一样
		参数4：方法的代理
		*/
		enhancer.setCallback(new MethodInterceptor() {
			
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodproxy) throws Throwable {
				// 执行目标类的方法
				myAspect.before();
				Object object=method.invoke(userService, args);
				//执行代理类的父类，即UserServiceImpl
				//methodproxy.invokeSuper(proxy,args);
				myAspect.after();
				return object;
			}
		});
		//创建代理
		UserServiceImpl proxyuserServiceImpl=(UserServiceImpl) enhancer.create();
		UserServiceImpl proxyuserse=null;
		return proxyuserServiceImpl;
	}

}
