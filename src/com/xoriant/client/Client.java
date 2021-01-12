package com.xoriant.client;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.xoriant.beans.Student;




public class Client {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Book book = new Book("Java Complete Reference", "Shuvendu", "Oreally", "Dont read this book, stay happy", 10, 10, new Date(), new Date(), BookType.REFERENCEBOOK);
		
		Student student = new Student("Kalpesh", new Date(), new Date(), "Kolkata", "123456789", "REG123456", "123");
		
		
		//Date date = new Date("10/10/2021");
		
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, book.getBookType().getMaxBorrowDays());
		
		IssuedBook issuebook = new IssuedBook(1, student, new Date(), c.getTime());
		
		
		session.save(book);
		session.save(student);
		session.save(issuebook);
		
		
		txn.commit();
		session.close();
		
		
//		System.out.println("All Employee : ");
//		session = factory.openSession();
//		List<Employee> allEmployee = session.createQuery("FROM Employee").getResultList();
//		System.out.println(allEmployee);
//		session.close();
		
		factory.close();

	}
	
	
	

}
