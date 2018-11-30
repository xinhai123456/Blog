package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;

public class QueryUserByID extends ActionSupport{
	private String userID;
	private UserService userService = new UserServiceImpl();
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.print(userID);
		List<User> users = userService.getUserByID(userID);
		request.setAttribute("users", users);
		return "success";
	}
	
}
