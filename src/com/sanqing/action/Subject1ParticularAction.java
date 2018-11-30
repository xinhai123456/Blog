package com.sanqing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Comment;
import com.sanqing.po.Subject1;
import com.sanqing.service.Subject1Service;
import com.sanqing.service.Subject1ServiceImpl;
/*
 * 查看文章详细信息
 */
public class Subject1ParticularAction extends ActionSupport{
	private int subject1ID;
	private Subject1Service subject1Service = new Subject1ServiceImpl();
	public int getSubject1ID() {
		return subject1ID;
	}
	public void setSubject1ID(int subject1ID) {
		this.subject1ID = subject1ID;
	}
	public String execute() throws Exception {
		Subject1 subject1 = subject1Service.showSubject1Particular(subject1ID);
		List<Comment> comments = subject1Service.getComments(subject1ID);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("comments", comments);
		ServletActionContext.getRequest().setAttribute("subject1", subject1);
		String role = request.getSession().getAttribute("role").toString();
		if(role.equals("user"))
			return "userSuccess";
		else
			return "adminSuccess";
	}
}
