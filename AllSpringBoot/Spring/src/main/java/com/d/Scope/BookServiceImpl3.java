package com.d.Scope;

public class BookServiceImpl3 implements BookService3 {
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