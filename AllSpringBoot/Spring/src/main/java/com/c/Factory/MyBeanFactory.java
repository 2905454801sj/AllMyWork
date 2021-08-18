package com.c.Factory;

public class MyBeanFactory {
	//创建实例
	public BookService2 createService() {
		return new BookServiceImpl2();
	}
}
