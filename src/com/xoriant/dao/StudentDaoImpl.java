package com.xoriant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Book;
import com.xoriant.beans.Student;

public class StudentDaoImpl implements StudentDao {
	
	private SessionFactory factory;
	
	public StudentDaoImpl()
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	

	@Override
	public Integer addStudent(Student student) {
		// TODO Auto-generated method stub
		Integer userId= null;
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(student);
		System.out.println(id);
		
		
		txn.commit();
		session.close();
		System.out.println("Saved Successfully");
		return userId;
		
	}

	@Override
	public List<Book> searchBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void  issueBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book returnBook() {
		// TODO Auto-generated method stub
		return null;
	}

}
