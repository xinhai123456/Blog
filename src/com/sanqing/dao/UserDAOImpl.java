package com.sanqing.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.User;
import com.sanqing.util.Page;



public class UserDAOImpl implements UserDAO{
	public User findByUserID(String userID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		User user = (User) session.get(User.class, userID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return user;
	}

	public void updateUser(User user) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.update(user); 
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

	public List<User> findUserByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from User");
		query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
		query.setFirstResult(page.getBeginIndex());//���ò�ѯ��¼��ʼλ��
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();//�ر�Session����
		return list;
	}
	
	public int findUserCount() {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from User");
		List list = query.list();					//��ѯ������浽list��
		int count = list.size();
		HibernateSessionFactory.closeSession();//�ر�Session����
		return count;
	}
	
	public List<User> findByID(String userID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from User as u where u.userID = ?");
		query.setString(0, userID);
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return list;
	}
	
	public List<User> findByName(String nickName) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Query query = session.createQuery("from User as u where u.nickName like :nick ");
		query.setString("nick","%"+nickName+"%");
		List list = query.list();					//��ѯ������浽list��
		HibernateSessionFactory.closeSession();		//�ر�Session����
		return list;
	}

	public void addUser(User user) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.save(user);//�����û���Ϣ
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}
	
	public void deleteUser(String userID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		User user = (User) session.get(User.class, userID);
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.delete(user);
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
	}

}
