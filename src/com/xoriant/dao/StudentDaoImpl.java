package com.xoriant.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import com.xoriant.beans.Book;

import com.xoriant.beans.Student;


public class StudentDaoImpl implements StudentDao {
	
	JdbcTemplate  jdbcTemplate ;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
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
		System.out.println("called");
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
	public List<Book> searchBookByKeyword(int keyword) {
		// TODO Auto-generated method stub
			System.out.println("Keyword"+keyword);
			
		
			
			Session session = factory.openSession();
			Transaction txn = session.beginTransaction();
			List<Book> book = null;
			String hql = "From Book b where b.bookId = "+keyword;
			System.out.println("hql"+hql);
			TypedQuery<Book> query = session.createQuery(hql);
			
			book = query.getResultList();
			System.out.println("Book which is searched"+book);
			txn.commit();
			session.close();
			return book;
			
			
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
