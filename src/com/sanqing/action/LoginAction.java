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
	private String id; 			// �����û����
	private String password;	// �����û�����
	private String role;		// �����û���ɫ
	
	private UserService userService = 
			new UserServiceImpl();
	
	private AdminService adminService = 
		new AdminServiceImpl();//����Աҵ���߼��������

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
		
		if("user".equals(role)) {//������û���ݵ�¼	
			if(userService.allowLogin(id, password)) {
				User userInfo = userService.getUserInfo(id);
				//�����û���¼��session��Χ
				Map session = ActionContext.getContext().getSession();
				session.put("userInfo", userInfo);						
				request.getSession().setAttribute("id", id);
				request.getSession().setAttribute("role", role);	
				return "userSuccess";
			}else {
				addActionError("���û���Ų����ڣ��������벻��ȷ!");
				return INPUT;
			}
		}else {
			if(adminService.allowLogin(id, password)) {
				Admin adminInfo = adminService.getAdminInfo(id);
				//�������Ա��¼��session��Χ
				Map session = ActionContext.getContext().getSession();
				session.put("adminInfo", adminInfo);
				request.getSession().setAttribute("role", role);
				return "adminSuccess";
			}else {
				addActionError("�ù���Ա�����ڣ��������벻��ȷ!");
				return INPUT;
			}
		}
	}
}
