package com.sanqing.service;

import com.sanqing.po.Admin;


public interface AdminService {
	//判断是否为合法管理员，从而决定是否允许登录
	public boolean allowLogin(String adminID,String password);
	//获得管理员信息
	public Admin getAdminInfo(String adminID);
	// 更新管理员账号信息
	public void updateAdmin(Admin admin);
}
