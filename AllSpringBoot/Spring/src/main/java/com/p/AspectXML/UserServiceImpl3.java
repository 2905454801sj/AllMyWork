package com.p.AspectXML;

public class UserServiceImpl3 implements UserService3{
	
	public void addUser() {
		System.out.println("aspect添加成功");
	}
	public void updateUser() {	
		//int i=1/0;
		System.out.println("aspect更新成功");
	}
	public void deleteUser() {
		System.out.println("aspect删除成功");
	}

}
