package com.d.Scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.a.IoC.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestScope {
	@Test
	public void demo1(){
		//Spring工厂
		String xmlPath="dBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		BookService3 bookService=applicationContext.getBean("bookserviceID",BookService3.class);
		BookService3 bookService1=applicationContext.getBean("bookserviceID",BookService3.class);
		
		System.out.println(bookService);
		System.out.println(bookService1);
	}		
}
