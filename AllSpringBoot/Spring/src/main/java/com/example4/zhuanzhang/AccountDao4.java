package com.example4.zhuanzhang;

public interface AccountDao4 {
	//汇款
	public void out(String outer,Integer money);
	//收款
	public void in(String inner,Integer money);

}
