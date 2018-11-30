package com.sanqing.service;

import com.sanqing.dao.CommentDAO;
import com.sanqing.dao.CommentDAOImpl;
import com.sanqing.po.Comment;

public class CommentServiceImpl implements CommentService{
	private CommentDAO commentDAO = new CommentDAOImpl();
	public boolean saveComment(Comment comment1){
		commentDAO.addComment(comment1);
		return true;
	}
}
