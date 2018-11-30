package com.sanqing.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Admin;
import com.sanqing.service.AdminService;
import com.sanqing.service.AdminServiceImpl;

public class AdminCountManagementAction extends ActionSupport{
	private String adminID;
	private String password;
	
	private AdminService adminService = new AdminServiceImpl();
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String execute() throws Exception {
		Admin admin = new Admin();
		if(password.isEmpty()){
			addActionError("ÃÜÂë²»ÄÜÎª¿Õ!");
			return INPUT;
		}
		admin.setAdminID(adminID);
		admin.setPassword(password);
		adminService.updateAdmin(admin);
		ServletActionContext.getRequest().setAttribute("admin", admin);
		return "adminUpdateSuccess";
	}
}
