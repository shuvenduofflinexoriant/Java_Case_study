package com.xoriant.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Book;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Student;

public class LiberianDAOImpl implements LiberianDAO {

	private SessionFactory factory;
	
	public LiberianDAOImpl(){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveStudentRegistration(Student student) {
		
		return false;
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

}
