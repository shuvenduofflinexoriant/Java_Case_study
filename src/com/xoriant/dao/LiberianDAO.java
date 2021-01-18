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
	public boolean editBook(Book book);
	public boolean approveStudentRegistration(Student student);
	public boolean approveBookReturn(int issuedId, Liberian liberian) throws BookReturnDealyException;
	public IssuedBook calculateFine(int issuedId);
	public IssuedBook collectFine(int issuedId, Liberian liberian);
	public List<IssuedBook> getAllBookIssued();
	public List<IssuedBook> getAllBookReturnRequests();
	public Liberian getLiberianById(String userId);
	
	
	public List<Student> approveStudentRegistration(); //this function is to get list of student with role as NewStudent
	public void getStudentById(String id , String rollno ,String reg); // this function update the following student id with assigned role,rollno,registration number
}
