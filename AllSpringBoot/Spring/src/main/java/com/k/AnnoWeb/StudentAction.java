package com.k.AnnoWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//web层注解Controller
@Controller("studentactionID")
public class StudentAction {
	@Autowired // 默认按照类型注入
	private StudentService studentservice;

	public void execute() {
		studentservice.addStudent();
	}

}
