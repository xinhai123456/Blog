package com.sanqing.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Admin;

public class AdminDAOImpl implements AdminDAO{
	public Admin findByAdminID(String adminID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Admin admin = (Admin) session.get(Admin.class, adminID);
		HibernateSessionFactory.closeSession();//关闭Session对象
		return admin;
	}

	public  void updateAdmin(Admin admin) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.update(admin); 
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
		
	}

}
