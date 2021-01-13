package com.xoriant.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Role;
import com.xoriant.beans.Status;
import com.xoriant.beans.Student;


public class BookDaoImpl implements BookDao{
	
	private SessionFactory factory;
	
	public BookDaoImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		/*Book book = new Book();
		book.setBookName("AAA");
		book.setAvailableQuantity(20);
		book.setTotalQuantity(30);
		book.setBookType(BookType.REFERENCEBOOK);
		
		Book book2 = new Book();
		book2.setBookName("BBB");
		book2.setAvailableQuantity(10);
		book2.setTotalQuantity(15);
		book2.setBookType(BookType.STORYBOOK);
		
		Student student = new Student();
		student.setName("Sanket");
		
		Student student = new Student();
		student.setName("Ramulal");
		session.save(student);
		
		session.save(book);
		session.save(book2);
		session.save(student);*/
		
		/*Student student = session.get(Student.class,13);
		student.setRole(Role.STUDENT);
		session.update(student);
		
		Student student1 = session.get(Student.class,26);
		student1.setRole(Role.STUDENT);
		session.update(student1);
		Book book3 = new Book();
		book3.setBookName("ZZZ");
		book3.setAvailableQuantity(1);
		book3.setTotalQuantity(15);
		book3.setBookType(BookType.STORYBOOK);
		session.save(book3);*/

		
		String hql = "FROM Book b WHERE b.availableQuantity > 0";
		TypedQuery<Book> query = session.createQuery(hql);
		books = query.getResultList();
		txn.commit();
		session.close();
		
		return books;
	}

	@Override
	public boolean issueBookRequest(Integer userId, int bookId) {
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
			else if (issuedBook.getStudent().getUserId().equals(userId) && issuedBook.getStatus().equals(Status.REQUESTEDRETURN)) {
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
			
			IssuedBook issuebook = new IssuedBook(bookId, student, new Date(), c.getTime());
			book.setAvailableQuantity(book.getAvailableQuantity()-1);
			
			session.update(book);
			session.save(issuebook);
			txn.commit();
			session.close();
			return true;
		}
		
		
	}

	
	@Override
	public Map<String,IssuedBook> getAllIssuedBooks(Integer userId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Map<String,IssuedBook> ibooks = new LinkedHashMap<String,IssuedBook>();
		String hql = "FROM IssuedBook i WHERE i.student.userId = "+userId;
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		
		for(IssuedBook issuedbook: issuedBooks) {
			if(issuedbook.getStatus().equals(Status.ISSUED)) {
				Book book = session.get(Book.class,issuedbook.getBookId());
				ibooks.put(book.getBookName(), issuedbook);
			}
			
		}
		
		txn.commit();
		session.close();
		return ibooks;
		
	}
	
	@Override
	public void returnBook(Integer issueId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		IssuedBook issuedbook = session.get(IssuedBook.class, issueId);
		issuedbook.setStatus(Status.REQUESTEDRETURN);
		
		session.update(issuedbook);
		txn.commit();
		session.close();
		
	
	}

	@Override
	public Map<String, IssuedBook> getAllRequestedReturnBooks(Integer userId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Map<String,IssuedBook> ibooks = new LinkedHashMap<String,IssuedBook>();
		
		String hql = "FROM IssuedBook i WHERE i.student.userId = "+userId;
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		
		for(IssuedBook issuedbook: issuedBooks) {
			if(issuedbook.getStatus().equals(Status.REQUESTEDRETURN)) {
				Book book = session.get(Book.class,issuedbook.getBookId());
				ibooks.put(book.getBookName(), issuedbook);
			}
			
		}
		
		txn.commit();
		session.close();
		return ibooks;
	}

	


}
