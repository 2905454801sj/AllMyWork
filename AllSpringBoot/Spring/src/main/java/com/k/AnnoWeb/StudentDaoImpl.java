package com.k.AnnoWeb;

import org.springframework.stereotype.Repository;

@Repository("studentdaoID")
public class StudentDaoImpl {
    
	public void save() {
		System.out.println("DAO添加成功");
	}
	
}
