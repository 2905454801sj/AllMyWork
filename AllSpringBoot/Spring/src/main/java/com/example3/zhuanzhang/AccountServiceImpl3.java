package com.example3.zhuanzhang;

public class AccountServiceImpl3 implements AccountService3 {

	private AccountDao3 accountDao;
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
		//int i=1/0;
		accountDao.in(inner, money);		
	}
	public AccountDao3 getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao3 accountDao) {
		this.accountDao = accountDao;
	}

}
