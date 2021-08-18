package com.a.IoC;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestDI {
	@Test
	public void demo1(){
		String xmlPath="aBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		BookService bookService=(BookService) applicationContext.getBean("bookServiceID");
		bookService.addBook();
	}
}
