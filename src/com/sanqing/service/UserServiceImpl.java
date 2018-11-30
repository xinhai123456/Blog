package com.sanqing.service;

import java.util.List;

import com.sanqing.dao.UserDAO;
import com.sanqing.dao.UserDAOImpl;
import com.sanqing.po.User;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;
import com.sanqing.util.PageUtil;


public class UserServiceImpl implements UserService{
	private UserDAO userDAO = new UserDAOImpl();
	
	public boolean saveUser(User user) {
		String userID = user.getUserID();
		if(userDAO.findByUserID(userID) == null){ //������û�ID�����ڣ��������
			userDAO.addUser(user);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean allowLogin(String userID, String password) {
		
		User user = userDAO.findByUserID(userID);
		if(user == null) {//�ж��Ƿ���ڸ�ID��ѧ��
			return false;
		}else {
			if(password.equals(user.getPassword())) {//�ж������Ƿ���ͬ
				return true;
			}else{
				return false;
			}
			
		}
	}

	public User getUserInfo(String userID) {
		return userDAO.findByUserID(userID);
	}
	
	public PageResult queryUserByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(), userDAO.findUserCount(), page.getCurrentPage());// �����ܼ�¼��������ҳ��Ϣ
		List<User> list = userDAO.findUserByPage(page);// ͨ����ҳ��Ϣȡ������
		PageResult result = new PageResult(page, list);// ��װ��ҳ��Ϣ�ͼ�¼��Ϣ�����ظ����ô�
		return result;
	}

	public List<User> getUserByID(String userID) {
		return userDAO.findByID(userID);             
	}
	
	public List<User> getUserByName(String nickName) {
		return userDAO.findByName(nickName);             //ͨ���û������鿴�������Ϣ
	}
	
	public void updateUser(User user){
		userDAO.updateUser(user);	
	}
	
	public void deleteUser(String userID) {
		userDAO.deleteUser(userID);
	}
}
