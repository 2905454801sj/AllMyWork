package com.h.Setter;

public class Person {
	
	private String name;
	private Integer age;
	
	private Address homeAddr;
	private Address companyAddr;
	
	public Person() {}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getHomeAddr() {
		return homeAddr;
	}
	public void setHomeAddr(Address homeAddr) {
		this.homeAddr = homeAddr;
	}
	public Address getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(Address companyAddr) {
		this.companyAddr = companyAddr;
	}
	@Override
	public String toString() {
		return "Person [pname=" + name + ", age=" + age + ", homeAddr=" + homeAddr + ", companyAddr=" + companyAddr
				+ "]";
	}
	
	

}
