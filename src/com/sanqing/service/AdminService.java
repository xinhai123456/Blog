package com.sanqing.service;

import com.sanqing.po.Admin;


public interface AdminService {
	//�ж��Ƿ�Ϊ�Ϸ�����Ա���Ӷ������Ƿ������¼
	public boolean allowLogin(String adminID,String password);
	//��ù���Ա��Ϣ
	public Admin getAdminInfo(String adminID);
	// ���¹���Ա�˺���Ϣ
	public void updateAdmin(Admin admin);
}
