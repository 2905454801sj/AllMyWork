package com.u.Junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:uBeans.xml")
public class Test1 {
	@Autowired // 与Junit整合，不需要在spring xml配置扫描
	private AccountService accountService;

	@Test
	public void demo1() {
		/*
		 * String xmlpath="uBeans.xml"; ApplicationContext applicationContext=new
		 * ClassPathXmlApplicationContext(xmlpath); AccountService
		 * accountService=(AccountService) applicationContext.getBean("accountService");
		 */
		accountService.transfer("Jason", "Joker", 666);
	}

}
