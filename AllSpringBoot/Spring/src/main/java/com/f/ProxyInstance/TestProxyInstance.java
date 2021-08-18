package com.f.ProxyInstance;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a.IoC.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestProxyInstance {
	@Test
	public void demo1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//Spring工厂
		String xmlPath="fBeans.xml";
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		BookService5 bookService=(BookService5) applicationContext.getBean("bookserviceID");
		bookService.addBook();
		//容器必须关闭，销毁方法才会执行。必须是单例bean
		//applicationContext.getClass().getMethod("close").invoke(applicationContext);
		//close方法在接口中没有定义，但是实现类中提供了，所以用反射可以实现类中所有的方法
		applicationContext.close();
	}		
}
