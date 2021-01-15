package com.xoriant.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Book;
import com.xoriant.beans.Student;
import com.xoriant.dao.BookDaoImpl;



@Controller
public class MyController {
	Student student;
		
	@RequestMapping("/")
	public ModelAndView welcomeHome() {
		ModelAndView modelAndView = new ModelAndView("Welcome");
		return modelAndView;
	}
	
	@RequestMapping("/borrow")
	public ModelAndView borrowBook() {
		ModelAndView modelAndView = new ModelAndView("BorrowBook");
		BookDaoImpl bookDao = new BookDaoImpl();
		List<Book> books = bookDao.getAllBooks();
		
		//System.out.println(books);
		modelAndView.addObject("books",books);
		return modelAndView;
	}
	
	@RequestMapping("/borrow/{bookId}")
	public ModelAndView addToIssuedBook(@PathVariable("bookId") int bookId) {
		ModelAndView modelAndView;
		
		BookDaoImpl bookDao = new BookDaoImpl();
	
		if(bookDao.issueBookRequest(13, bookId)) {
			modelAndView = new ModelAndView("BookIssueSuccess");
		}
		else {
			modelAndView = new ModelAndView("BookIssueFail");
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/issuedBooks")
	public ModelAndView issuedBooks() {
		ModelAndView modelAndView= new ModelAndView("IssuedBooks");
		
		BookDaoImpl bookDao = new BookDaoImpl();
		modelAndView.addObject("issuedBooks",bookDao.getAllIssuedBooks(13));
		modelAndView.addObject("reqReturnedBooks",bookDao.getAllRequestedReturnBooks(13));
		
		return modelAndView;
	}
	
	@RequestMapping("/returnBook/{issueId}")
	public ModelAndView returnBook(@PathVariable("issueId") int issueId) {
		
		BookDaoImpl bookDao = new BookDaoImpl();
		bookDao.returnBook(issueId);
		ModelAndView modelAndView= new ModelAndView("ReturnBook");
		
		return modelAndView;
	}
	
	@RequestMapping("/returnedBooks")
	public ModelAndView returnedBooks() {
		ModelAndView modelAndView= new ModelAndView("ReturnedBooks");
		BookDaoImpl bookDao = new BookDaoImpl();
		modelAndView.addObject("returnedBooks",bookDao.getAllReturnedBooks(13));
	
		return modelAndView;
	}
	
}
