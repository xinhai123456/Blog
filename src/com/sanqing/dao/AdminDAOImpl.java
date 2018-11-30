package com.sanqing.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Admin;

public class AdminDAOImpl implements AdminDAO{
	public Admin findByAdminID(String adminID) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Admin admin = (Admin) session.get(Admin.class, adminID);
		HibernateSessionFactory.closeSession();//�ر�Session����
		return admin;
	}

	public  void updateAdmin(Admin admin) {
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;//����һ���������
		try{
			transaction = session.beginTransaction();//��������
			session.update(admin); 
			transaction.commit();//�ύ����
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//����ع�
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
		
	}

}
