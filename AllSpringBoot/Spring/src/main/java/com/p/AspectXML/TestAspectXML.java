package com.p.AspectXML;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectXML {

	@Test
	public void demo1() {
		String xmlPath = "pBeans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 获得目标类
		UserService3 userService = (UserService3) applicationContext.getBean("userid");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
