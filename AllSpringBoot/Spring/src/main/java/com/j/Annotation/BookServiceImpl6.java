package com.j.Annotation;

import org.springframework.stereotype.Component;

@Component("bookServiceID")

public class BookServiceImpl6 implements BookService6 {
	public void addBook() {
		System.out.println("添加成功");
	}
}