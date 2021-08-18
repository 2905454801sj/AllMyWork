package com.example1.zhuanzhang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	@Test
	public void demo1() {
		String xmlpath="Example1.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		AccountService accountService=(AccountService) applicationContext.getBean("accountService");
		accountService.transfer("Jason", "Joker", 666);
	}

}
