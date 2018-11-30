package com.sanqing.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Comment;
import com.sanqing.po.Subject1;
import com.sanqing.service.CommentService;
import com.sanqing.service.CommentServiceImpl;
import com.sanqing.service.Subject1Service;
import com.sanqing.service.Subject1ServiceImpl;

/*
 * 获得指定id的文章
 */
public class CommentAddAction extends ActionSupport{
	private int subject1ID;
	private String comment_user;
	private String comment;
	private Date comment_time;
	
	private CommentService commentService = new CommentServiceImpl();
	private Subject1Service subject1Service = new Subject1ServiceImpl();
	
	public int getSubject1ID() {
		return subject1ID;
	}

	public void setSubject1ID(int subject1ID) {
		this.subject1ID = subject1ID;
	}

	public String getComment_user() {
		return comment_user;
	}

	public void setComment_user(String comment_user) {
		this.comment_user = comment_user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}
	
	public String execute() throws Exception {
		
		Comment comment1 = new Comment();
		Date comment_time = new Date();
		SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss");
		String kk = k.format(comment_time);
		comment1.setSubject1ID(subject1ID);
		comment1.setComment_user(comment_user);
		comment1.setComment(comment);
		comment1.setComment_time(kk);
		
	
		
		if(commentService.saveComment(comment1)) {
			this.addActionMessage("添加成功!");
			//return SUCCESS;
		}else {
			this.addActionError("添加失败,请重新尝试!!!");
			//return INPUT;
		}
		
		List<Subject1> subject1s = subject1Service.specifidFindSubject1(comment1.getSubject1ID());
		int id = subject1s.get(0).getSubject1ID();
		System.out.println(id);
		List<Comment> comments = subject1Service.getComments(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subject1s", subject1s);
		request.setAttribute("comments", comments);
		return SUCCESS;
	}
}
