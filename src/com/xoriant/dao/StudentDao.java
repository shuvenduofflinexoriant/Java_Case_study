package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Book;
import com.xoriant.beans.Student;


public interface StudentDao {
	
	public String addStudent(Student student);
	public List<Book> searchBook();
	public void issueBook();
	public Book returnBook();
	

}
