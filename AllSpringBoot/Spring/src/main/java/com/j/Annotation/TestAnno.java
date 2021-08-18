package com.j.Annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestAnno {
	@Test
	public void demo1(){
		String xmlPath="jBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		BookService6 bookService=(BookService6) applicationContext.getBean("bookServiceID");
		bookService.addBook();
	}
}
