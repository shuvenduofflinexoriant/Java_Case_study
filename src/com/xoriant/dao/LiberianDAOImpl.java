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
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Role;
import com.xoriant.beans.Student;

public class LiberianDAOImpl implements LiberianDAO {
private SessionFactory factory ;
	
	public LiberianDAOImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	    factory = meta.getSessionFactoryBuilder().build();
     }

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(book);
		txn.commit();
		session.close();
		return true;
	}

	@Override
	public List<Student>approveStudentRegistration() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		String hql = "From Student e where e.role = " + Role.NEWSTUDENT.ordinal() ;
		TypedQuery<Student> query = session.createQuery(hql);
		List<Student> studentData = query.getResultList();
		session.close();
		return studentData;
	}

	@Override
	public boolean approveBookReturn(IssuedBook issuedBook) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculateFine(IssuedBook issuedBook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IssuedBook> viewAllBookBorrows() {
		// TODO Auto-generated method stub
		return null;
	}

	
		
	

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Student student1 = new Student("prakhar");
		Student studen2 = new Student("shuvendu");
		Student student3 = new Student("anjali");
		session.save(student1);
		session.save(studen2);
		session.save(student3);
		txn.commit();
		session.close();
		
		
		
	}

	@Override
	public void getStudentById(int id, String rollno, String reg) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Student student = (Student)session.get(Student.class, id);
		student.setRole(Role.STUDENT);
		student.setRegistrationNumber(reg);
		student.setRollNumber(rollno);
		session.update(student);
		System.out.println(student);
		txn.commit();
		session.close();
		
	}
	
	
}
