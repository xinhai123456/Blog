package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;

public class QueryUserByName extends ActionSupport{
	private String nickName;
	private UserService userService = new UserServiceImpl();
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> users = userService.getUserByName(nickName);
		request.setAttribute("users", users);
		return "success";
	}
	
}
