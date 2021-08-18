package com.u.Junit;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
		//int i=1/0;
		accountDao.in(inner, money);		
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
