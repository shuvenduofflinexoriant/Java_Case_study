package com.xoriant.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Employee;
import com.xoriant.beans.Student;
import com.xoriant.dao.EmployeeDAO;
import com.xoriant.dao.EmployeeDAOImpl;

public class Client {

	public static void main(String[] args) {
		
		Student student = new Student("Shuvendu",'A');
		Employee emp = new Employee("Amit","SS",6);
		
		EmployeeDAO empdao = new EmployeeDAOImpl();
		
	//	empdao.addEmployee(emp);
		
		//System.out.println(empdao.listEmployees());
		
		//System.out.println(empdao.getEmployeeNames());
		
		//System.out.println(empdao.searchEmployee(1));
		
		System.out.println(empdao.listEmployeesOrderByName());
	}

}
