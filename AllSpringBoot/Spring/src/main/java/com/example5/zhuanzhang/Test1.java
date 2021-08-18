package com.example5.zhuanzhang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	@Test
	public void demo1() {
		String xmlpath="Example5.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		AccountService4 accountService=(AccountService4) applicationContext.getBean("accountService");
		accountService.transfer("Joker", "Jason",2000);
	}

}
