package com.t.JDBCDAOSupport;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBCDAOSupport {
	
	@Test
	public void demo1(){
			/*User user=new User();
			user.setSname("C3P0");
			user.setSno("123123");*/
		String XMLPath="tBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(XMLPath);	
		UserDAO userDAO=(UserDAO) applicationContext.getBean("UserID");
		List<User> alluser=userDAO.findAll();
		for(User user:alluser) {
			System.out.println(user);
		}
	}

}
