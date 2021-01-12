package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Book;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Liberian;
import com.xoriant.beans.Student;
import com.xoriant.exception.BookReturnDealyException;

//Approve Return Book
//Add Book
//View Book Borrow
//Approve Student registration
//Calculate Book Delay Fine



public interface LiberianDAO {
	public boolean addBook(Book book);
	public boolean approveStudentRegistration(Student student);
	
	public boolean approveBookReturn(int issuedId, Liberian liberian) throws BookReturnDealyException;
	public double calculateFine(int issuedId);
	public List<IssuedBook> getAllBookIssued();
	public List<IssuedBook> getAllBookReturnRequests();
}
