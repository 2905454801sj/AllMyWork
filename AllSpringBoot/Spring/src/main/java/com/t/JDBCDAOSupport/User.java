package com.t.JDBCDAOSupport;

public class User {
	
	private String sname;
	private String sno;

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "User [sname=" + sname + ", sno=" + sno + "]";
	}
	

}
