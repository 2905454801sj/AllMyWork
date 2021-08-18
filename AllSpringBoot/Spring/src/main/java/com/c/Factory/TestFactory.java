package com.c.Factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a.IoC.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestFactory {
	@Test
	public void demo1(){
		//自定义工厂
		MyBeanFactory myBeanFactory=new MyBeanFactory();
		BookService2 bookService=myBeanFactory.createService();
		bookService.addBook();
	}
	@Test
	public void demo2(){
		//Spring工厂
		String xmlPath="cBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		BookService2 bookService=applicationContext.getBean("bookserviceID",BookService2.class);
		bookService.addBook();
	}
}
