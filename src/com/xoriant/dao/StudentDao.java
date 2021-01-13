package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Book;
import com.xoriant.beans.Student;


public interface StudentDao {
	
	public Integer addStudent(Student student);
	public List<Book> searchBookByKeyword(int keyword);
	public void issueBook();
	public Book returnBook();
	
}