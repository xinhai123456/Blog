package com.sanqing.service;

import java.util.List;

import com.sanqing.dao.Subject1DAO;
import com.sanqing.dao.Subject1DAOImpl;
import com.sanqing.po.Comment;
import com.sanqing.po.Subject1;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;
import com.sanqing.util.PageUtil;

public class Subject1ServiceImpl implements Subject1Service {
	private Subject1DAO subject1DAO = new Subject1DAOImpl();

	public boolean saveSubject1(Subject1 subject1) {
		String subject1Tile = subject1.getSubject1Title();
		subject1DAO.addSubject1(subject1);
		return true;
	}

	public PageResult querySubject1ByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(), subject1DAO.findSubject1Count(), page.getCurrentPage());// 根据总记录数创建分页信息
		List<Subject1> list = subject1DAO.findSubject1ByPage(page);// 通过分页信息取得文章
		PageResult result = new PageResult(page, list);// 封装分页信息和记录信息，返回给调用处
		return result;
	}
	
	public PageResult querySelfSubject1ByAuthor(Page page,String userID) {
		page = PageUtil.createPage(page.getEveryPage(), subject1DAO.findSubject1Count(), page.getCurrentPage());// 根据总记录数创建分页信息
		List<Subject1> list = subject1DAO.findSubject1ByAuthor(page,userID);// 通过分页信息取得文章
		PageResult result = new PageResult(page, list);// 封装分页信息和记录信息，返回给调用处
		return result;
	}

	public Subject1 showSubject1Particular(int subject1ID) {
		return subject1DAO.findSubject1ByID(subject1ID);
	}

	public void updateSubject1(Subject1 subject1) {
		subject1DAO.updateSubject1(subject1);
	}

	public void deleteSubject1(int subject1ID) {
		subject1DAO.deleteSubject1(subject1ID);
	}

	public PageResult likeQueryBySubject1Title(String subject1Title, Page page) {
		page = PageUtil.createPage(page.getEveryPage(), subject1DAO.findLinkQueryCount(subject1Title),
				page.getCurrentPage());// 根据总记录数创建分页信息
		List<Subject1> list = subject1DAO.likeQueryByTitle(subject1Title, page);// 通过分页信息模糊查询文章
		PageResult result = new PageResult(page, list);// 封装分页信息和记录信息，返回给调用处
		return result;
	}

	public List<Subject1> randomFindSubject1(int number) {
		return subject1DAO.randomFindSubject1(number);
	}
	
	public List<Subject1> specifidFindSubject1(int subject1ID) {
		return subject1DAO.specifidFindSubject1(subject1ID);
	}

	public List<Comment> getComments(int id) {
		return subject1DAO.getComments(id);
	}
	
}
