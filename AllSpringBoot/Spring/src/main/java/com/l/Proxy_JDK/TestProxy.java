package com.l.Proxy_JDK;

import org.junit.Test;

public class TestProxy {
	
	@Test
	public void demo1() {
		UserService userService=MyBeanfactory.createUser();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
