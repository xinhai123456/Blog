package com.sanqing.service;

import java.util.List;

import com.sanqing.po.Comment;
import com.sanqing.po.Subject1;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;

public interface Subject1Service {
	 
	public boolean saveSubject1(Subject1 subject1);
	 
	public PageResult querySubject1ByPage(Page page);
	
	public PageResult querySelfSubject1ByAuthor(Page page,String userID);
	 
	public Subject1 showSubject1Particular(int subject1ID);
	 
	public void updateSubject1(Subject1 subject1);
	 
	public void deleteSubject1(int subject1ID);
	 
	public PageResult likeQueryBySubject1Title(String subject1Title,Page page);
	 
	public List<Subject1> randomFindSubject1(int number);
	
	public List<Subject1> specifidFindSubject1(int subject1ID);
	
	public List<Comment> getComments(int id);
	
}
