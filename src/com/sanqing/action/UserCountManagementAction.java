package com.sanqing.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;


public class UserCountManagementAction extends ActionSupport{
	private String userID;
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
		if(password.isEmpty()){
			addActionError("ÃÜÂë²»ÄÜÎª¿Õ!");
			return INPUT;
		}
		user.setUserID(userID);
		user.setPassword(password);
	
		userService.updateUser(user);
		ServletActionContext.getRequest().setAttribute("user", user);
		return "userUpdateSuccess";
	}
}
