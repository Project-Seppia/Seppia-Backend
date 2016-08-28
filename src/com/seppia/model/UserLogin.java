package com.seppia.model;

public class UserLogin {
	//TODO remove this class and model and dao and table in DB
	//We use cognito login and register now
	String user_id;
	String user_mail;
	String user_pw;
	String user_token;
	String user_token_expire;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_token() {
		return user_token;
	}
	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}
	public String getUser_token_expire() {
		return user_token_expire;
	}
	public void setUser_token_expire(String user_token_expire) {
		this.user_token_expire = user_token_expire;
	}
}
