package com.sanqing.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Subject1;
import com.sanqing.service.Subject1Service;
import com.sanqing.service.Subject1ServiceImpl;

//该Action用来接收文章参数，并调用业务逻辑组件Subject1Service来完成文章添加
public class Subject1AddAction extends ActionSupport{
	private String subject1Title;
	private String subject1Parse;
	private String author;
	private Date subject1_time;
	

	private Subject1Service subject1Service = new Subject1ServiceImpl();
	
	public String getSubject1Title() {
		return subject1Title;
	}
	public void setSubject1Title(String subject1Title) {
		this.subject1Title = subject1Title;
	}
	
	public String getSubject1Parse() {
		return subject1Parse;
	}
	public void setSubject1Parse(String subject1Parse) {
		this.subject1Parse = subject1Parse;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getSubject1_time() {
		return subject1_time;
	}
	public void setSubject1_time(Date subject1_time) {
		this.subject1_time = subject1_time;
	}
	

	public String execute() throws Exception {
		Subject1 subject1 = new Subject1();
		Date subject1_time = new Date();
		SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss");
		String kk = k.format(subject1_time);
		subject1.setSubject1Title(subject1Title);
		subject1.setSubject1Parse(subject1Parse);
		subject1.setAuthor(author);
		subject1.setSubject1_time(kk);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(subject1Service.saveSubject1(subject1)) {
			request.setAttribute("tipMessage", "发布成功！");
			return SUCCESS;
		}else {
			request.setAttribute("tipMessage", "发布失败！");
			return INPUT;
		}
	}
}
