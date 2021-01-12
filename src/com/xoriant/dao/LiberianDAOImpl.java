package com.xoriant.dao;

import java.util.Date;
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
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Liberian;
import com.xoriant.beans.Role;
import com.xoriant.beans.Status;
import com.xoriant.beans.Student;
import com.xoriant.exception.BookReturnDealyException;

public class LiberianDAOImpl implements LiberianDAO {

	private SessionFactory factory;
	
	public LiberianDAOImpl(){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public boolean addBook(Book book) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Integer id = (Integer) session.save(book);
		txn.commit();
		session.close();
		return id > 0;
	}

	@Override
	public boolean approveStudentRegistration(Student student) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
//		Student dbstudent = session.get(Student.class, student.getUserId());
		student.setRole(Role.STUDENT);
		session.update(student);
		txn.commit();
		session.close();
		return true;
	}

	@Override
	public boolean approveBookReturn(int issuedId, Liberian liberian) throws BookReturnDealyException {
		
		Session session = factory.openSession();
		String hql = "From IssuedBook I WHERE I.issueId = " + issuedId;
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		IssuedBook issuedBook = query.getSingleResult();
		
		
		Date today = new Date();
		if(issuedBook.getFine() <= 0 && today.after(issuedBook.getReturningDate())) {
			session.close();
			throw new BookReturnDealyException();
		}
		
		
		Transaction txn = session.beginTransaction();
		
		issuedBook.setApproverId(liberian.getUserId());
		issuedBook.setReturnedDate(today);
		session.update(issuedBook);
		txn.commit();
		session.close();
		return true;
	}

	@Override
	public double calculateFine(int issuedId) {
		
		Session session = factory.openSession();
		String hql = "From IssuedBook I WHERE I.issueId = " + issuedId;
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		IssuedBook issuedBook = query.getSingleResult();
	
		int days = -1 * issuedBook.getDaysLeft();
		
		
		session.close();
		return 0;
	}

	@Override
	public List<IssuedBook> getAllBookIssued() {
		Session session = factory.openSession();
		
		
		String hql = "From IssuedBook";
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		
		session.close();
		return issuedBooks;
	}

	@Override
	public List<IssuedBook> getAllBookReturnRequests() {
		Session session = factory.openSession();
		String hql = "From IssuedBook e where e.status = "+ Status.REQUESTRETURN.ordinal();
		TypedQuery<IssuedBook> query = session.createQuery(hql);
		List<IssuedBook> issuedBooks = query.getResultList();
		
		session.close();
		return issuedBooks;
	}

}
