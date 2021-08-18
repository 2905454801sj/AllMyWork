package com.q.AspectAnno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectAnno {

	@Test
	public void demo1() {
		String xmlPath = "qBeans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 获得目标类
		UserService4 userService = (UserService4) applicationContext.getBean("userid");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
