package com.sanqing.service;

import com.sanqing.dao.AdminDAO;
import com.sanqing.dao.AdminDAOImpl;
import com.sanqing.po.Admin;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAO = new AdminDAOImpl();
	
	public boolean allowLogin(String adminID, String password) {
		Admin admin = adminDAO.findByAdminID(adminID);
		if(admin == null) {//�ж��Ƿ���ڸ�ID�Ĺ���Ա
			return false;
		}else {
			if(password.equals(admin.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
		}
	}

	public Admin getAdminInfo(String adminID) {
		return adminDAO.findByAdminID(adminID);
	}

	public  void updateAdmin(Admin admin) {
		adminDAO.updateAdmin(admin);	
	}
}
