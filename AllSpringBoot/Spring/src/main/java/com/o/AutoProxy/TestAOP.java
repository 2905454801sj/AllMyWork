package com.o.AutoProxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

	@Test
	public void demo1() {
		String xmlPath = "oBeans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 获得目标类
		UserService2 userService = (UserService2) applicationContext.getBean("userID");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
