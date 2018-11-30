package com.sanqing.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Admin;
import com.sanqing.po.User;
import com.sanqing.service.AdminService;
import com.sanqing.service.AdminServiceImpl;
import com.sanqing.service.UserService;
import com.sanqing.service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {
	private String id; 			// 接受用户编号
	private String password;	// 接受用户密码
	private String role;		// 接受用户角色
	
	private UserService userService = 
			new UserServiceImpl();
	
	private AdminService adminService = 
		new AdminServiceImpl();//管理员业务逻辑组件引用

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if("user".equals(role)) {//如果以用户身份登录	
			if(userService.allowLogin(id, password)) {
				User userInfo = userService.getUserInfo(id);
				//保存用户记录到session范围
				Map session = ActionContext.getContext().getSession();
				session.put("userInfo", userInfo);						
				request.getSession().setAttribute("id", id);
				request.getSession().setAttribute("role", role);	
				return "userSuccess";
			}else {
				addActionError("该用户编号不存在，或者密码不正确!");
				return INPUT;
			}
		}else {
			if(adminService.allowLogin(id, password)) {
				Admin adminInfo = adminService.getAdminInfo(id);
				//保存管理员记录到session范围
				Map session = ActionContext.getContext().getSession();
				session.put("adminInfo", adminInfo);
				request.getSession().setAttribute("role", role);
				return "adminSuccess";
			}else {
				addActionError("该管理员不存在，或者密码不正确!");
				return INPUT;
			}
		}
	}
}
