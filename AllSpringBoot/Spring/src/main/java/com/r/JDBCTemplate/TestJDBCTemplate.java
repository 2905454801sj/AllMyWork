package com.r.JDBCTemplate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBCTemplate {
	
	@Test
	public void demo1(){
		User user=new User();
		user.setSname("JDBCTemplate");
		user.setSno("123123");
		String XMLPath="rBeans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(XMLPath);	
		UserDAO userDAO=(UserDAO) applicationContext.getBean("UserID");
		userDAO.update(user);
	}

}
