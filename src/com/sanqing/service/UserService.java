package com.sanqing.service;

import java.util.List;

import com.sanqing.po.User;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;


public interface UserService {
	 
	public boolean allowLogin(String userID,String password);
	 
	public User getUserInfo(String userID);
	
	public PageResult queryUserByPage(Page page);
	
	public List<User> getUserByID(String userID);
	
	public List<User> getUserByName(String nickName);
	
	public boolean saveUser(User user);

	public void updateUser(User user);

	public void deleteUser(String userID);
}
