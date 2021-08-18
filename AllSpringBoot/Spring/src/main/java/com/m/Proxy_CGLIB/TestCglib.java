package com.m.Proxy_CGLIB;

import org.junit.Test;

public class TestCglib {
	
	@Test
	public void demo1() {
		UserServiceImpl userService=MyBeanfactory.createUser();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}

}
