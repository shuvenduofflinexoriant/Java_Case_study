package com.xoriant.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Student;
import com.xoriant.dao.LiberianDAOImpl;



public class Client {

	public static void main(String[] args) {
		

		System.out.println("hi");
		LiberianDAOImpl liberianDaoImpl = new LiberianDAOImpl();
		List<Student>studentList = liberianDaoImpl.approveStudentRegistration();
		System.out.println(studentList);
		
		
	}

}
