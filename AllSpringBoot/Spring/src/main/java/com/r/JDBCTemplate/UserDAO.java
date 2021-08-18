package com.r.JDBCTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO {
	//jdbc模板将由spring注入
	private JdbcTemplate jdbcTemplate;
	public void update(User user) {
		String sql = "insert into spring (sname,sno) value(?,?)";
		Object args[] = {user.getSname(),user.getSno()}; 
		jdbcTemplate.update(sql, args);
		int temp = jdbcTemplate.update(sql, args); 
		if(temp > 0) {
			System.out.println("文章新增成功"); 
		}else
		System.out.println("新增出现错误");
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
