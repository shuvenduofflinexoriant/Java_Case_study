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
import com.xoriant.beans.BookType;

public class BookDaoImpl implements BookDao {
	
	private SessionFactory factory;
	public BookDaoImpl()
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public Book addBook() {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setBookId(1);
		book.setBookName("C++");
		book.setBookType(BookType.REFERENCEBOOK);
		book.setAuthor("BalaguruSwami");
		book.setPublication("AAA");
		book.setAvailableQuantity(5);
		book.setTotalQuantity(5);
		book.setDescription("Good One");
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(book);
		System.out.println(id);
		
		txn.commit();
		session.close();
		System.out.println("Saved Successfully");
		return book;
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = null;
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		String hql = "FROM Book b WHERE b.availableQuantity > 0";
		TypedQuery<Book> query = session.createQuery(hql);
		books = query.getResultList();
		txn.commit();
		session.close();
		
		return books;
	}
}
