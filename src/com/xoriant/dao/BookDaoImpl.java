package com.xoriant.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.xoriant.beans.Book;
import com.xoriant.beans.BookType;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Status;
import com.xoriant.beans.Student;

public class BookDaoImpl implements BookDao {
	
	private SessionFactory factory;
	public BookDaoImpl()
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public Book addBook(Book book) {
		
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

	@Override
	public boolean issueBookRequest(String userId, int bookId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Book book = session.get(Book.class,bookId);
		Student student = session.get(Student.class,userId);
		
		String hql = "FROM IssuedBook";
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		
		int counter=0;
		for(IssuedBook issuedBook: issuedBooks) {
			if(issuedBook.getStudent().getUserId().equals(userId) && issuedBook.getStatus().equals(Status.ISSUED)) {
				counter+=1;
			}
			else if (issuedBook.getStudent().getUserId().equals(userId) && issuedBook.getStatus().equals(Status.REQUESTRETURN)) {
				counter+=1;
			}
		}
		
		System.out.println(counter);
		
		if(counter >= student.getRole().getMaxBookBorrow()) {
			txn.commit();
			session.close();
			return false;
		}
		else {
			Calendar c = Calendar.getInstance();    
			c.add(Calendar.DATE, book.getBookType().getMaxBorrowDays());
			
			IssuedBook issuebook = new IssuedBook(book, student, new Date(), c.getTime());
			book.setAvailableQuantity(book.getAvailableQuantity()-1);
			
			session.update(book);
			session.save(issuebook);
			txn.commit();
			session.close();
			return true;
		}
		
	}

	@Override
	public void returnBook(Integer issueId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		IssuedBook issuedbook = session.get(IssuedBook.class, issueId);
		issuedbook.setStatus(Status.REQUESTRETURN);
		
		session.update(issuedbook);
		txn.commit();
		session.close();
	}

	

	@Override
	public List<Book> getBookByKeyword(String keyword) {
		List<Book> books = null;
		Session session =  factory.openSession();
		Transaction txn = session.beginTransaction();
		
		String hql = "From Book b where b.bookName like '%"+keyword+"%' OR b.author like '%"+keyword+"%' OR b.publication like '%"+keyword+"%' OR b.description like '%"+keyword+"%'";
		TypedQuery<Book> query = session.createQuery(hql);
		books = query.getResultList();
		txn.commit();
		session.close();
		
		return books;
	}

	@Override
	public List<IssuedBook> getAllReturnedBooks(String userId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM IssuedBook i WHERE i.student.userId = '"+userId+"' AND i.status = "+Status.RETURNED.ordinal();
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		txn.commit();
		session.close();
		return issuedBooks;
	}

	@Override
	public List<IssuedBook> getIssuedANDRequestedReturnBooks(String userId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM IssuedBook i WHERE i.student.userId = '"+userId+"' AND i.status is not "+Status.RETURNED.ordinal();
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		txn.commit();
		session.close();
		return issuedBooks;
	}

	@Override
	public String getBookReturnAlert(String userId) {
		List<IssuedBook> issuedBooks = getIssuedANDRequestedReturnBooks(userId);
		Date now = new Date();
		
		int bookCount = 0;
		for(IssuedBook book : issuedBooks) {
			long duration  = book.getReturningDate().getTime() - now.getTime();
			if(duration < 0) {
				bookCount++;
			}else {
				long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
				
				if(diffInDays < 3) {
					bookCount++;
				}
			}
			
			
		}
		
		if(bookCount  == 0) return null;
		
		return "You have "+bookCount+" Books to return in 2 Days!!";
	}
}