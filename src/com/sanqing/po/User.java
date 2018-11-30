package com.sanqing.po;
/*
 * 用户表,保存用户ID，系统密码等
 */
public class User {
	private String userID;
	
	private String password;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
