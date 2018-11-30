package com.sanqing.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.User;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public class QueryUserAction extends ActionSupport {
	private int currentPage;		//当前页
	private UserService studentService = new UserServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(10);//每页显示10条记录
		page.setCurrentPage(currentPage);//设置当前页
		PageResult pageResult = studentService.queryUserByPage(page);
		List<User> users = pageResult.getList();//获得文章记录
		page = pageResult.getPage();//获得分页信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("users", users);
		request.setAttribute("page", page);
	    return "adminSuccess";
	}
}
