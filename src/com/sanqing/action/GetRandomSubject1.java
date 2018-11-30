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
 * 获得随机文章
 */
public class GetRandomSubject1 extends ActionSupport{
	private Subject1Service subject1Service = new Subject1ServiceImpl();
	public String execute() throws Exception {
		List<Subject1> subject1s = subject1Service.randomFindSubject1(1);
		if(subject1s.toString()=="[]")
		{
			return SUCCESS;
		}
		int id = subject1s.get(0).getSubject1ID();
		List<Comment> comments = subject1Service.getComments(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subject1s", subject1s);
		request.setAttribute("comments", comments);
		String role = request.getSession().getAttribute("role").toString();
		if(role.equals("user"))
			return "userSuccess";
		else
			return "adminSuccess";
	}
}
