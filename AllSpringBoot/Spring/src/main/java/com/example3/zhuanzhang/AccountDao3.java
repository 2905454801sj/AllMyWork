package com.example3.zhuanzhang;

public interface AccountDao3 {
	//汇款
	public void out(String outer,Integer money);
	//收款
	public void in(String inner,Integer money);

}
