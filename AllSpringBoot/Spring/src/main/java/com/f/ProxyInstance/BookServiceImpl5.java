package com.f.ProxyInstance;

public class BookServiceImpl5 implements BookService5 {
	public void addBook() {
    	   System.out.println("实例工厂添加成功");
       }
	public void Init() {
		System.out.println("已初始化");
	}
	public void Destory() {
		System.out.println("已销毁");
	}
}