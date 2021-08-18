package com.r.JDBCTemplate;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestAPI {
	public static void main(String[] args) {
	//创建数据源，连接池
	BasicDataSource dataSource=new BasicDataSource();
	//基本四项
	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/Spring?serverTimezone=UTC");
	dataSource.setUsername("root");
	dataSource.setPassword("123456");
	//创建模板
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	jdbcTemplate.setDataSource(dataSource);
	//通过API操作
	jdbcTemplate.update("insert into spring values(?,?)", "JASON","12345678");
	}
}
