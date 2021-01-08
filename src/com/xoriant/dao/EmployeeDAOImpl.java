package com.xoriant.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.mysql.cj.jdbc.interceptors.SessionAssociationInterceptor;
import com.xoriant.beans.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory factory;
	
	public EmployeeDAOImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}
	
	
	@Override
	public Integer addEmployee(Employee employee) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Integer id = (Integer) session.save(employee);
		txn.commit();
		session.close();
		return id;
	}

	@Override
	public void updateEmployee(Integer employeeId, int exp) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		employee.setExp(exp);
		session.update(employee);
		txn.commit();
		session.close();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Employee employee = session.get(Employee.class, employeeId);
		session.delete(employee);
		txn.commit();
		session.close();
	}
	

	@Override
	public List<Employee> listEmployees() {
		Session session = factory.openSession();
		
		
		String hql = "From Employee";
		TypedQuery<Employee> query = session.createQuery(hql);
		List<Employee> employees = query.getResultList();
		
		session.close();
		return employees;
	}

	@Override
	public List<String> getEmployeeNames() {
		Session session = factory.openSession();
		String hql = "SELECT E.empName From Employee E";
		TypedQuery<String> query = session.createQuery(hql);
		List<String> employees = query.getResultList();
		session.close();
		return employees;
	}


	@Override
	public Employee searchEmployee(int empId) {
		Session session = factory.openSession();
		String hql = "From Employee E WHERE E.empId = " + empId;
		TypedQuery<Employee> query = session.createQuery(hql);
		Employee employee = query.getSingleResult();
		session.close();
		return employee;
	}


	@Override
	public List<Employee> listEmployeesOrderByName() {
Session session = factory.openSession();
		
		
		String hql = "From Employee E ORDER BY E.empName";
		TypedQuery<Employee> query = session.createQuery(hql);
		List<Employee> employees = query.getResultList();
		
		session.close();
		return employees;
	}

}



//private Integer empId;
//
//@Column(name="emp_name")
//private String empName;
//
//@Column(name="emp_designation")
//private String designation;
//
//@Column(name="exp")
//private Integer exp;
