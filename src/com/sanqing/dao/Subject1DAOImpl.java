package com.sanqing.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanqing.hibernate.HibernateSessionFactory;
import com.sanqing.po.Comment;

import com.sanqing.po.Subject1;
import com.sanqing.util.Page;

public class Subject1DAOImpl implements Subject1DAO{
	public void addSubject1(Subject1 subject1){
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.save(subject1); 
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}

	public Subject1 findSubject1ByTitle(String subject1Title) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Subject1 as sub where sub.subject1Title = ?");
		query.setString(0, subject1Title);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		if(list.size() == 0) {
			return null;							//返回null
		}else {
			return (Subject1) list.get(0);		 
		}
	}

	public List<Subject1> findSubject1ByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Subject1");
		query.setMaxResults(page.getEveryPage());//设置查询记录数
		query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}
	
	@Override
	public List<Subject1> findSubject1ByAuthor(Page page,String userID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		System.out.print(userID);
		String id = "\'"+userID+"\'";
		System.out.print(id);
		Query query = session.createQuery("from Subject1 as sub where sub.author = " + id );
		query.setMaxResults(page.getEveryPage());//设置查询记录数
		query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}

	public int findSubject1Count() {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Subject1");
		List list = query.list();					//查询结果保存到list中
		int count = list.size();
		HibernateSessionFactory.closeSession();//关闭Session对象
		return count;
	}

	public Subject1 findSubject1ByID(int subject1ID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Subject1 subject = (Subject1) session.get(Subject1.class, subject1ID);
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return subject;
	}


	public void updateSubject1(Subject1 subject1) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.update(subject1);//更新文章信息
			System.out.println("haha");
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}

	public void deleteSubject1(int subject1ID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Subject1 subject1 = (Subject1) session.get(Subject1.class, subject1ID);
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.delete(subject1);
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}

	public List<Subject1> likeQueryByTitle(String subjectTitle,Page page) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Subject1 as sub where sub.subject1Title like :title ");
		query.setString("title","%"+subjectTitle+"%");
		query.setMaxResults(page.getEveryPage());//设置查询记录数
		query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}

	public int findLinkQueryCount(String subject1Title) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Subject1 as sub where sub.subject1Title like :title ");
		query.setString("title","%"+subject1Title+"%");
		List list = query.list();					//查询结果保存到list中
		int count = list.size();
		HibernateSessionFactory.closeSession();//关闭Session对象
		return count;
	}

	public List<Subject1> randomFindSubject1(int number) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		String hqlstr = "from Subject1 as sub order by rand()";
		Query query = session.createQuery(hqlstr);
		query.setMaxResults(number);//设置查询记录数
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}
	
	public List<Subject1> specifidFindSubject1(int subject1ID) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		String hqlstr = "from Subject1 as sub where sub.subject1ID =" + subject1ID;
		Query query = session.createQuery(hqlstr);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}

	@Override
	public List<Comment> getComments(int id) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		String hqlstr = "from Comment as com where com.subject1ID =" +id +"order by com.comment_time";
		Query query = session.createQuery(hqlstr);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭Session对象
		return list;
	}
	
}
