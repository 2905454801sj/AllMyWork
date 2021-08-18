package com.example4.zhuanzhang;

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
