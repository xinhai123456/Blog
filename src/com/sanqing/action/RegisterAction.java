package com.sanqing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;

public class RegisterAction extends ActionSupport{
	private String userID;
	private String nickName;
	private String password;
	private UserService userService = new UserServiceImpl();
	
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
	
	public String execute() throws Exception {
		User user = new User();
		if(userID.isEmpty() || password.isEmpty()){
			return INPUT;
		}
		user.setUserID(userID);
		user.setPassword(password);
		
		if(userService.saveUser(user)) {
			return "registerSuccess";
		}else {
			this.addActionError("该ID已被注册，请重新输入！!");
			return INPUT;
		}
	}
}
