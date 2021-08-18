package com.n.Proxy_JDK2;

public class UserServiceImpl1 implements UserService1{
	
	public void addUser() {
		System.out.println("半自动代理添加成功");
	}
	public void updateUser() {	
		System.out.println("半自动代理更新成功");
	}
	public void deleteUser() {
		System.out.println("半自动代理删除成功");
	}

}
