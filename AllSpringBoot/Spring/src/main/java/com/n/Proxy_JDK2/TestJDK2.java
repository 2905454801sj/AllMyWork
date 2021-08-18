package com.n.Proxy_JDK2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDK2 {
	
	@Test
	public void demo1() {
		String xmlPath="nBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		//获得代理类
		UserService1 userService=(UserService1) applicationContext.getBean("proxyuserID");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
