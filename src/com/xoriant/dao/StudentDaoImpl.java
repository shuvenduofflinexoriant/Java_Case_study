package com.xoriant.dao;

import java.util.List;

import javax.persistence.TypedQuery;

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
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		String userId1 = (String) session.save(student);
		txn.commit();
		session.close();
		System.out.println("Saved Successfully");
		return userId1;
		
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


	@Override
	public List<Book> searchBookByKeyword(int keyword) {

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "From Book b where b.bookId = "+keyword;
		TypedQuery<Book> query = session.createQuery(hql);
		List<Book> books = query.getResultList();
		txn.commit();
		session.close();
		return books;
	}

}
