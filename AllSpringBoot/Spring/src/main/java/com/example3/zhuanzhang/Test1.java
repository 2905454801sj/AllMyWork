package com.example3.zhuanzhang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	@Test
	public void demo1() {
		String xmlpath="Example3.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		AccountService3 accountService=(AccountService3) applicationContext.getBean("accountService");
		accountService.transfer("Jason", "Joker", 666);
	}

}
