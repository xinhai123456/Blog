package com.sanqing.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;

public class UserDeleteAction extends ActionSupport{
	private String userID;
	private UserService userService = new UserServiceImpl();
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String execute() throws Exception {
		userService.deleteUser(userID);
		HttpServletRequest request = ServletActionContext.getRequest();
	    request.setAttribute("tipMessage", "É¾³ý³É¹¦£¡");
		return SUCCESS;
	}
}
