package com.sanqing.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Subject1;
import com.sanqing.service.Subject1Service;
import com.sanqing.service.Subject1ServiceImpl;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class LikeQuerySubject1Action extends ActionSupport {
	private String subject1Title;	 
	private int currentPage;		//当前页
	private Subject1Service subject1Service = new Subject1ServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getSubject1Title() {
		return subject1Title;
	}

	public void setSubject1Title(String subject1Title) {
		this.subject1Title = subject1Title;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(100);//每页显示100条记录
		page.setCurrentPage(currentPage);//设置当前页
		PageResult pageResult = subject1Service.likeQueryBySubject1Title(subject1Title, page);
		List<Subject1> subject1s = pageResult.getList();// 
		List<Subject1> newSubject1s = new ArrayList<Subject1>();//新的记录
		//给关键字标红
		for(Subject1 subject1 : subject1s) {
			String newTitle = subject1.getSubject1Title().replaceAll(subject1Title,
						"<font color='red'>" + subject1Title + "</font>");
			subject1.setSubject1Title(newTitle);
			newSubject1s.add(subject1);
		}
		
		page = pageResult.getPage();//获得分页信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subject1s", newSubject1s);
		request.setAttribute("page", page);
		String role = request.getSession().getAttribute("role").toString();
		if(role.equals("user"))
			return "userSuccess";
		else
			return "adminSuccess";
	}
}
