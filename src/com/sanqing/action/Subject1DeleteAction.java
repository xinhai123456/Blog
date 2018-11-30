package com.sanqing.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.service.Subject1Service;
import com.sanqing.service.Subject1ServiceImpl;

public class Subject1DeleteAction extends ActionSupport{
	private int subject1ID;
	private Subject1Service subject1Service = new Subject1ServiceImpl();
	public int getSubject1ID() {
		return subject1ID;
	}
	public void setSubject1ID(int subject1ID) {
		this.subject1ID = subject1ID;
	}
	public String execute() throws Exception {
		subject1Service.deleteSubject1(subject1ID);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String role = request.getSession().getAttribute("role").toString();
		if(role.equals("user"))
			return "userSuccess";
		else
			return "adminSuccess";
	}
}
