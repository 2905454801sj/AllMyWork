package com.b.StaticFactory;

public class MyBeanFactory {
	//创建实例
	public static BookService1 createService() {
		return new BookServiceImpl1();
	}
}
