package com.xoriant.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Liberian;
import com.xoriant.beans.Login;
import com.xoriant.commonutil.Utility;

public class LoginDAOImpl implements LoginDAO {

	private SessionFactory factory;
	public LoginDAOImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public boolean register(String userId, String password) {
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		password = Utility.getMd5(password);
		
		Login login = new Login(userId,password);
		 session.save(login);
		
		
		txn.commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean login(String userId, String password) {
		password = Utility.getMd5(password);
		Session session =  factory.openSession();
		try {
		
		String hql = "From Login WHERE userId = '"+userId+"'"; // + userId;
		TypedQuery<Login> queryLiberian = session.createQuery(hql);
		Login login = queryLiberian.getSingleResult();
		return login.getPassword().equals(password);
		}catch (Exception e) {
			
		}
		return false;
		
		
		
	}

	@Override
	public boolean changePassword(String userId, String password, String newPassword) {
		
		if(!login(userId,password)) {
			return false;
		}
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		newPassword = Utility.getMd5(newPassword);
		
		Login login = new Login(userId,newPassword);
		session.update(login);
		
		
		txn.commit();
		session.close();
		
		return true;
	}

}
