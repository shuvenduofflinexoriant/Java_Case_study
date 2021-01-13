package com.xoriant.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Book;
import com.xoriant.beans.Role;
import com.xoriant.beans.Student;
import com.xoriant.dao.BookDaoImpl;
import com.xoriant.dao.StudentDaoImpl;





@Controller

public class MyController {

	@RequestMapping("/")
	public ModelAndView welcomeHome() {
		ModelAndView modelAndView = new ModelAndView("Welcome");
		return modelAndView;
	}
	

	
	
	@RequestMapping(value="/StudentRegistration")
	public ModelAndView getStudent()
	{
		ModelAndView modelAndView = new ModelAndView("StudentRegistration");
		System.out.println("Sucess!!!!");
		return modelAndView;
		
		
	}
	
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
		public ModelAndView submitAdmissionForm(@RequestParam("name") String name,@RequestParam("address") String address, @RequestParam("contactNumber") String contactNumber,@RequestParam("admissionDate") String admissionDate, @RequestParam("releaseDate") String releaseDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Student student = new Student();
		student.setName(name);
		student.setAddress(address);
		student.setContactNumber(contactNumber);
		
		try
		{
			Date date1 = formatter.parse(admissionDate);
			Date date2 = formatter.parse(releaseDate);
			
			
			student.setAdmissionDate(date1);
			student.setReleaseDate(date2);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Invalid date formate");
		}
		
		student.setRole(Role.NEWSTUDENT);
		
		ModelAndView modelAndView  = new ModelAndView("RegistrationSuccess");
		modelAndView.addObject(student);
		StudentDaoImpl studentDao = new StudentDaoImpl();
		studentDao.addStudent(student);
		
		
	
		return modelAndView;
	}
	
	@RequestMapping("/borrow")
	public ModelAndView borrowBook() {
		ModelAndView modelAndView = new ModelAndView("BorrowBook");
		BookDaoImpl bookDao = new BookDaoImpl();
		Book book = new Book();
		book = bookDao.addBook();
		List<Book> books = bookDao.getAllBooks();
		
		System.out.println(books);
		modelAndView.addObject("books",books);
		return modelAndView;
	}

	
	@RequestMapping(value="/SearchBook")
	public ModelAndView getBook()
	{
		ModelAndView modelAndView = new ModelAndView("SearchBook");
		return modelAndView;
	}
	
	
}