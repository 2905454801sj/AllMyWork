package com.example2.zhuanzhang;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

public class AccountServiceImpl1 implements AccountService1 {

	private AccountDao1 accountDao;
	// 需要spring注入模板
	private TransactionTemplate transactionTemplate;

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void transfer(final String outer, final String inner, final Integer money) {
		// 事物回调
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				accountDao.out(outer, money);
				// int i=1/0;
				accountDao.in(inner, money);
			}
		});

	}

}
