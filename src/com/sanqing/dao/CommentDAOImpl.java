package com.sanqing.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Comment;

public class CommentDAOImpl implements CommentDAO{
	public void addComment(Comment comment1){
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.save(comment1); 
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}
}
