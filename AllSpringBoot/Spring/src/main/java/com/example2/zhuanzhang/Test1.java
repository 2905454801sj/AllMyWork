package com.example2.zhuanzhang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example3.zhuanzhang.AccountService3;

public class Test1 {
	@Test
	public void demo1() {
		String xmlpath="Example3.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		AccountService3 accountService=(AccountService3) applicationContext.getBean("proxyAccountService");
		accountService.transfer("Jason", "Joker", 666);
	}

}
