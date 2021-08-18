package com.i.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollData {

	private String[] a1;
	private List<String> l1;
	private Set<String> s1;
	private Map<String,String> m1;
	private Properties p1;
	public String[] getA1() {
		return a1;
	}
	public void setA1(String[] a1) {
		this.a1 = a1;
	}
	public List<String> getL1() {
		return l1;
	}
	public void setL1(List<String> l1) {
		this.l1 = l1;
	}
	public Set<String> getS1() {
		return s1;
	}
	public void setS1(Set<String> s1) {
		this.s1 = s1;
	}
	public Map<String, String> getM1() {
		return m1;
	}
	public void setM1(Map<String, String> m1) {
		this.m1 = m1;
	}
	public Properties getP1() {
		return p1;
	}
	public void setP1(Properties p1) {
		this.p1 = p1;
	}
	@Override
	public String toString() {
		return "CollData [\n a1=" + Arrays.toString(a1) + ", \n l1=" + l1 + ", \n s1=" + s1 + ",\n m1=" + m1 + ",\n p1=" + p1 + "]";
	}
	
	
	
}
