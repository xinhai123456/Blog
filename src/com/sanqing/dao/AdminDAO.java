package com.sanqing.dao;

import com.sanqing.po.Admin;


public interface AdminDAO {
	public Admin findByAdminID(String adminID);

	public  void updateAdmin(Admin admin); 
}
