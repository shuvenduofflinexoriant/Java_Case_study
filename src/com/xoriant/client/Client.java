package com.xoriant.client;

import com.xoriant.beans.Student;
import com.xoriant.dao.StudentDaoImpl;

public class Client {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.setName("Anjali");
		
		student1.setAddress("Pune");
		student1.setContactNumber("1234567899");
		student1.setRegistrationNumber("16earcs302");
		student1.setRollNumber("16earcs302");
		
		
		Student student2 = new Student();
		student1.setName("Rehan");
		student1.setAddress("Pune");
		student1.setContactNumber("1234567899");
		student1.setRegistrationNumber("16earcs301");
		student1.setRollNumber("16earcs301");
		
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.addStudent(student1);
		
		studentDao.addStudent(student2);
	}

}
