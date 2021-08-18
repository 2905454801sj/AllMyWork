package com.o.AutoProxy;

public class UserServiceImpl2 implements UserService2 {

	public void addUser() {
		System.out.println("自动代理添加成功");
	}

	public void updateUser() {
		System.out.println("自动代理更新成功");
	}

	public void deleteUser() {
		System.out.println("自动代理删除成功");
	}

}
