package com.i.Collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestColl {
	@Test
	public void demo1() {
		String xmlPath = "iBeans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		CollData collData = (CollData) applicationContext.getBean("collID");
		System.out.println(collData);
	}
}
