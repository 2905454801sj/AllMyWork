package com.q.AspectAnno;

import org.springframework.stereotype.Service;
@Service("userid")
public class UserServiceImpl4 implements UserService4{
	
	public void addUser() {
		System.out.println("注解添加成功");
	}
	public void updateUser() {	
		//int i=1/0;
		System.out.println("注解更新成功");
	}
	public void deleteUser() {
		System.out.println("注解删除成功");
	}

}
