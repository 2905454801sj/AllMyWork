package com.b.StaticFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a.IoC.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestStaticFactory {
	@Test
	public void demo1(){
		//自定义工厂
		BookService1 bookService=(BookService1) MyBeanFactory.createService();
		bookService.addBook();
	}
	@Test
	public void demo2(){
		//Spring工厂
		String xmlPath="bBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		BookService1 bookService=applicationContext.getBean("bookserviceID",BookService1.class);
		bookService.addBook();
	}
}
