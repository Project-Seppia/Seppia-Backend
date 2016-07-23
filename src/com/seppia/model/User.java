package com.seppia.model;

public class User {
	private String userName;
	private String pwd;
	private String userId;
	private String registerTime;
	
	
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String name){
		this.userName = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
}
