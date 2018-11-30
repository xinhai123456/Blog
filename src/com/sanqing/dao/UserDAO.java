package com.sanqing.dao;

import java.util.List;

import com.sanqing.po.User;
import com.sanqing.util.Page;


public interface UserDAO {
	
	public void addUser(User user);
	
	public User findByUserID(String userID);

	public void updateUser(User user);

	public List<User> findByID(String userID);
	
	public List<User> findByName(String nickName);

	public void deleteUser(String userID); 
	
	public List<User> findUserByPage(Page page);
	
	public int findUserCount();
}
