package com.g.xmlConstuctor;

public class User {
	private Integer age;
	private String name;
	private Integer uid;
	

	public User(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public User(String name, Integer uid) {
		super();
		this.name = name;
		this.uid = uid;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", uid=" + uid + "]";
	}
	
}
