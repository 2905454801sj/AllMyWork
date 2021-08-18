package com.a.IoC;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	//一般方法，接口=实现类
	//private BookDao bookDao=new BookDao();
	//Spring方法如下，接口+Setter
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public void addBook() {
		this.bookDao.save();
	}
}