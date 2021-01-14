package com.xoriant.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Liberian;

public class AdminDaoImpl implements AdminDao {

private SessionFactory factory ;
	
	public AdminDaoImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    factory = meta.getSessionFactoryBuilder().build();
     }
	
	@Override
	public void addLiberian(Liberian liberian) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(liberian);
		txn.commit();
		session.close();
	}

}
