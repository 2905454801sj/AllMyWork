package com.example3.zhuanzhang;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl3 extends JdbcDaoSupport implements AccountDao3{
	
	public void out(String outer,Integer money) {
		this.getJdbcTemplate().update("update account set money=money-? where username=?",
				money,outer);
	}
	public void in(String inner,Integer money) {
		this.getJdbcTemplate().update("update account set money=money+? where username=?",
				money,inner);
	}

}
