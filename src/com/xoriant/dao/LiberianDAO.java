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
	public List<Student> approveStudentRegistration(); //this function is to get list of student with role as NewStudent
	public void getStudentById(int id , String rollno ,String reg); // this function update the following student id with assigned role,rollno,registration number
    public boolean approveBookReturn(IssuedBook issuedBook);
	public double calculateFine(IssuedBook issuedBook);
	public List<IssuedBook> viewAllBookBorrows();
	public void addStudent() ; //this function is to dummy function to check the modules working for approveStudentRegistration
}
