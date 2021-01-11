package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Book;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Student;

//Approve Return Book
//Add Book
//View Book Borrow
//Approve Student registration
//Calculate Book Delay Fine



public interface LiberianDAO {
	public boolean addBook(Book book);
	public boolean approveStudentRegistration(Student student);
	
	public boolean approveBookReturn(IssuedBook issuedBook);
	public double calculateFine(IssuedBook issuedBook);
	public List<IssuedBook> viewAllBookBorrows();
}
