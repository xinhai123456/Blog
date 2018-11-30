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
		if(userDAO.findByUserID(userID) == null){ //如果该用户ID不存在，允许添加
			userDAO.addUser(user);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean allowLogin(String userID, String password) {
		
		User user = userDAO.findByUserID(userID);
		if(user == null) {//判断是否存在该ID的学生
			return false;
		}else {
			if(password.equals(user.getPassword())) {//判断密码是否相同
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
		page = PageUtil.createPage(page.getEveryPage(), userDAO.findUserCount(), page.getCurrentPage());// 根据总记录数创建分页信息
		List<User> list = userDAO.findUserByPage(page);// 通过分页信息取得文章
		PageResult result = new PageResult(page, list);// 封装分页信息和记录信息，返回给调用处
		return result;
	}

	public List<User> getUserByID(String userID) {
		return userDAO.findByID(userID);             
	}
	
	public List<User> getUserByName(String nickName) {
		return userDAO.findByName(nickName);             //通过用户姓名查看其相关信息
	}
	
	public void updateUser(User user){
		userDAO.updateUser(user);	
	}
	
	public void deleteUser(String userID) {
		userDAO.deleteUser(userID);
	}
}
