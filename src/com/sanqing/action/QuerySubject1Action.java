package com.sanqing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Subject1;
import com.sanqing.service.Subject1Service;
import com.sanqing.service.Subject1ServiceImpl;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class QuerySubject1Action extends ActionSupport {
	private int currentPage;		//��ǰҳ
	private Subject1Service subject1Service = new Subject1ServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(10);//ÿҳ��ʾ10����¼
		page.setCurrentPage(currentPage);//���õ�ǰҳ
		PageResult pageResult = subject1Service.querySubject1ByPage(page);
		List<Subject1> subject1s = pageResult.getList();//������¼�¼
		page = pageResult.getPage();//��÷�ҳ��Ϣ
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subject1s", subject1s);
		request.setAttribute("page", page);
		String role = request.getSession().getAttribute("role").toString();
		if(role.equals("user"))
			return "userSuccess";
		else
			return "adminSuccess";
	}
}
