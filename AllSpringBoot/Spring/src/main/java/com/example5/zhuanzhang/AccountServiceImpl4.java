package com.example5.zhuanzhang;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//事务详情在注解中配置
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class AccountServiceImpl4 implements AccountService4 {

	private AccountDao4 accountDao;
	
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
		//int i=1/0;
		accountDao.in(inner, money);		
	}
	public AccountDao4 getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao4 accountDao) {
		this.accountDao = accountDao;
	}

}
