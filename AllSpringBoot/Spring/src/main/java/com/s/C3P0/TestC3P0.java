package com.s.C3P0;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestC3P0 {
	
	@Test
	public void demo1(){
			/*User user=new User();
			user.setSname("C3P0");
			user.setSno("123123");*/
		String XMLPath="sBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(XMLPath);	
		UserDAO userDAO=(UserDAO) applicationContext.getBean("UserID");
		List<User> alluser=userDAO.findAll();
		for(User user:alluser) {
			System.out.println(user);
		}
	}

}
