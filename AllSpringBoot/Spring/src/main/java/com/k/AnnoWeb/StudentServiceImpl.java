package com.k.AnnoWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	public StudentDao studentdao;

	@Autowired
	@Qualifier("studentdaoID") // 按照名称注入
	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}

	public void addStudent() {
		studentdao.save();
		// System.out.println("SERVICE添加成功");
	}

}
