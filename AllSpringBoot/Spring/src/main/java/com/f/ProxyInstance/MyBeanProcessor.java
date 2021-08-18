package com.f.ProxyInstance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("前方法"+beanName);
		return bean;
		/**
		 * 因为return null所以抛空指针异常，spring new了一个对象 此方法在初始化方法之前执行，将new的对象返回null
		 */
	}

	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("后方法"+beanName);
		// 生成JDK动态代理
		// bean为目标对象，生成的为代理对象
		return Proxy.newProxyInstance(MyBeanProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),
				new InvocationHandler() {

					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//执行目标方法
						System.out.println("------开启事务");
						Object object=method.invoke(bean, args);
						System.out.println("------关闭事务");
						return null;
					}
				});
	}

}
