package com.h.Setter;

public class Address {
	
	private String addr;
	private String tel;
	
	public Address() {}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Address(String addr, String tel) {
		super();
		this.addr = addr;
		this.tel = tel;
	}
	
	

}
