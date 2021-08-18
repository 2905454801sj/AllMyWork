package com.a.IoC;

public class BookDaoImpl implements BookDao {
	public void save() {
		System.out.println("DI add book");
	}
}
