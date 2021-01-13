package com.xoriant.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Book;
import com.xoriant.beans.BookType;
import com.xoriant.dao.LiberianDAOImpl;



@Controller
public class MyController {
	

	
//		
//	@RequestMapping("/welcome/{userName}")
//	public ModelAndView sayHello(@PathVariable("userName") String name) {
//		ModelAndView modelAndView = new ModelAndView("Welcome");
//		modelAndView.addObject("msg", "Welcome "+name);
//		return modelAndView;
//	}
//	
//	
//	
//	@RequestMapping("/allexecutives")
//	public ModelAndView showAllExecutives() {
//		ModelAndView modelAndView = new ModelAndView("ShowExecutives");
//		Client client = new Client();
//		Set<Executive> executives = client.getService().populateExecutives(client.getService().populateRequests());
//		List<Executive> executiveslist = executives.stream().sorted((e1,e2) -> e1.getExecutiveId() - e2.getExecutiveId()).collect(Collectors.toList());
////		String executiveslist = "| executiveid | executive_name | department |<br/>+-------------+----------------+------------+";
////		for(Executive executive : executives) {
////			System.out.println(executive);
////			executiveslist += "\n| "+executive.getExecutiveId()+" | "+executive.getExecutiveName()+" | "+executive.getDepartment()+" |";
////		}
//		
//		modelAndView.addObject("executiveslist",executiveslist);
//		
//		//modelAndView.addObject(executiveslist);
//		return modelAndView;
//	}
//	
//	@RequestMapping("/allrequests")
//	public ModelAndView showAllRequests() {
//		ModelAndView modelAndView = new ModelAndView("ShowRequests");
//		
//		Client client = new Client();
//		Set<Request> requestslist = client.getService().populateRequests();
//        modelAndView.addObject("requestslist",requestslist);
//		return modelAndView;
//	}
//	
//	@RequestMapping("/empreq/{empId}")
//	public ModelAndView sayHello(@PathVariable("empId") int empId) {
//		ModelAndView modelAndView = new ModelAndView("ShowRequests");
//		Client client = new Client();
//		Set<Request> requestslist = client.getService().populateRequests().stream().filter(em -> em.getExecutiveId() == empId).collect(Collectors.toSet());
//		 modelAndView.addObject("requestslist",requestslist);
//		return modelAndView;
//	}
//	
	@RequestMapping("/")
	public ModelAndView welcomeHome() {
		ModelAndView modelAndView = new ModelAndView("Welcome");
		return modelAndView;
	}
	
	@RequestMapping(value="/addbook" , method= RequestMethod.GET) 
	public ModelAndView getForm() {
		ModelAndView modelAndView = new ModelAndView("addBook");
		return modelAndView;
	}
	
	@RequestMapping(value="/submitForm", method=RequestMethod.POST)
	public ModelAndView displayForm(@RequestParam("bookName") String bookName ,@RequestParam("author") String author,@RequestParam("publication") String publication,@RequestParam("description") String description,@RequestParam("availableQuantity") String availableQuantity,@RequestParam("publishDate") String publishDate,@RequestParam("availableOn") String availableOn ,@RequestParam("totalQuantity") String totalQuantity,@RequestParam("bookType") String bookType) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPublication(publication);
		book.setDescription(description);
		book.setTotalQuantity(Integer.parseInt(totalQuantity));
		book.setAvailableQuantity(Integer.parseInt(availableQuantity));
		 try {
			Date date1 = formatter.parse(publishDate);
			Date date2 = formatter.parse(availableOn);
			
			book.setPublishDate(date1);
			book.setAvailableOn(date2);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("invalid date Format");
		}
		 
		BookType bookpref = BookType.valueOf(bookType);
		book.setBookType(bookpref);
		
		 
		
		System.out.println(book);
		
		LiberianDAOImpl liberianDaoImpl = new LiberianDAOImpl();
		Boolean x = liberianDaoImpl.addBook(book);
		ModelAndView modelAndView = new ModelAndView("bookSuccess");
		return modelAndView;
		
	}
			
}
