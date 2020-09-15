package com.weiwei.Entity;

public class Admin {
	private String uname;
	private String upwd;
	
	
	
	public Admin() {
		super();
	}
	public String getUname() {
		return uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Admin(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	@Override
	public String toString() {
		return "Admin [uname=" + uname + ", upwd=" + upwd + "]";
	}
	
	
	
	
}
