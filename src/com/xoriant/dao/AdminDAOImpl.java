package com.xoriant.dao;

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

public class AdminDAOImpl implements AdminDAO {

	private SessionFactory factory;
	public AdminDAOImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public String addLiberian(Liberian liberian,String password) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String userId = (String) session.save(liberian);
		password = Utility.getMd5(password);
		Login login = new Login(userId,password);
		session.save(login);
		txn.commit();
		session.close();
		return userId;
	}
}
