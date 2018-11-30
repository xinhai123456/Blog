package com.sanqing.dao;

import java.util.List;

import com.sanqing.po.Comment;
import com.sanqing.po.Subject1;
import com.sanqing.util.Page;

public interface Subject1DAO {
	public void addSubject1(Subject1 subject1);

	public Subject1 findSubject1ByTitle(String subject1Title);

	public List<Subject1> findSubject1ByPage(Page page);

	public List<Subject1> findSubject1ByAuthor(Page page,String userID);

	public int findSubject1Count();

	public Subject1 findSubject1ByID(int subject1ID);

	public void updateSubject1(Subject1 subject1);

	public void deleteSubject1(int subjectID);

	public List<Subject1> likeQueryByTitle(String subject1Title,Page page);

	public int findLinkQueryCount(String subject1Title);

	public List<Subject1> randomFindSubject1(int number);

	public List<Subject1> specifidFindSubject1(int subject1ID);

	public List<Comment> getComments(int id);
}
