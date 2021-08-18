package com.g.xmlConstuctor;

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

public class TestConstuctor {
	@Test
	public void demo1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		//Spring工厂
		String xmlPath="gBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		User user=(User) applicationContext.getBean("userID");
		System.out.println(user);
	}		
}
