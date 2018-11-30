package com.sanqing.po;
import java.util.Date;

public class Comment {
	private int id;
	private int subject1ID;
	private String comment_user;
	private String comment;
	private String comment_time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubject1ID() {
		return subject1ID;
	}
	public void setSubject1ID(int subjectID) {
		this.subject1ID = subjectID;
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
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	
	
}
