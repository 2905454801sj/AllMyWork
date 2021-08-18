package com.e.LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("前方法"+beanName);
		return bean;
		/**因为return null所以抛空指针异常，spring new了一个对象
		    此方法在初始化方法之前执行，将new的对象返回null
		 */
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("后方法"+beanName);
		return bean;
	}

}
