package com.k.AnnoWeb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class TestAnnoWeb {
	@Test
	public void demo1() {
		String xmlPath = "kBeans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		StudentAction studentaction = (StudentAction) applicationContext.getBean("studentactionID");
		studentaction.execute();
	}
}
//运行后加载xml文件，然后扫描整个package有没有注解，首先找到controller
//调用getbean时，找到autowired，再转到接口service类，最后回到StudentAction.java继续完成方法
