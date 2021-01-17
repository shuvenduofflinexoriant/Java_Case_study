package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Book;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Student;


public interface StudentDao {
	
	public String addStudent(Student student,String password);
	public List<Book> searchBookByKeyword(int keyword);
	public void issueBook();
	public Book returnBook();
	public Student getStudentById(String userId);
	

}
