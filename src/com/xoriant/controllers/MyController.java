package com.xoriant.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Book;
import com.xoriant.beans.BookType;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Liberian;
import com.xoriant.beans.Student;
import com.xoriant.client.Client;
import com.xoriant.dao.LiberianDAO;
import com.xoriant.dao.LiberianDAOImpl;
import com.xoriant.dao.StudentDao;
import com.xoriant.dao.StudentDaoImpl;
import com.xoriant.exception.BookReturnDealyException;



@Controller
public class MyController {

	private Liberian liberian;
	private LiberianDAO liberianDAO;
	private StudentDao studentDAO;

	public MyController() {
		liberianDAO = new LiberianDAOImpl();
		studentDAO = new StudentDaoImpl();
	}
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


	//	issuedBooks
	//	approveReturn/


	@RequestMapping("/approveReturn/{issuedId}")
	public ModelAndView approveReturnRequest(@PathVariable("issuedId") int issuedId) {

		ModelAndView modelAndView = new ModelAndView("ApproveBookReturn");
		try {
			liberianDAO.approveBookReturn(issuedId, liberian);
		} catch (BookReturnDealyException e) {
			//Display Fine 
			modelAndView = new ModelAndView("CalculateFine");
			IssuedBook issuedBook = liberianDAO.calculateFine(issuedId);
			double fine = issuedBook.getFine();
			int days = issuedBook.getDaysLeft() * -1;
			modelAndView.addObject("bookname",issuedBook.getBook().getBookName());
			modelAndView.addObject("bookid",issuedBook.getBook().getBookId());
			modelAndView.addObject("booktype",issuedBook.getBook().getBookType());
			modelAndView.addObject("fineperday",issuedBook.getBook().getBookType().getFinePerDay());
			modelAndView.addObject("issuedId",issuedBook.getIssueId());
			modelAndView.addObject("fine",fine);
			modelAndView.addObject("days",days);
		}finally {
			
			return modelAndView;
		}
	}
	
	
	@RequestMapping("/collectFine/{issuedId}")
	public ModelAndView collectFine(@PathVariable("issuedId") int issuedId) {

		ModelAndView modelAndView = new ModelAndView("FineCollectSuccess");
		
		IssuedBook issuedBook = liberianDAO.collectFine(issuedId,liberian);
		
	
		modelAndView.addObject("fine",issuedBook.getFine());
		modelAndView.addObject("approver",issuedBook.getApproverId());
		modelAndView.addObject("bookname",issuedBook.getBook().getBookName());
		modelAndView.addObject("userid",issuedBook.getStudent().getUserId());
		modelAndView.addObject("username",issuedBook.getStudent().getName());
//		<h4>Book : <%=request.getAttribute("bookname") %></h4>
//		<h4>User Id : <%=request.getAttribute("userid") %></h4>
//		<h4>Name : <%=request.getAttribute("username") %></h4>
//		<h4>Fine Amount: <%=request.getAttribute("fine") %></h4>
		return modelAndView;
	
	}

	@RequestMapping("/viewreturnrequests")
	public ModelAndView viewReturnRequests() {
		ModelAndView modelAndView = new ModelAndView("ViewReturnRequests");

		List<IssuedBook> issuedBooks = liberianDAO.getAllBookReturnRequests();
		modelAndView.addObject("issuedBooks",issuedBooks);
		return modelAndView;
	}


	@RequestMapping("/allissuedbooks")
	public ModelAndView showAllRequests() {
		ModelAndView modelAndView = new ModelAndView("ViewIssuedBook");
		LiberianDAO liberianDAO = new LiberianDAOImpl();
		List<IssuedBook> issuedBooks = liberianDAO.getAllBookIssued();
		modelAndView.addObject("issuedBooks",issuedBooks);
		return modelAndView;
	}


	@RequestMapping("/StudentRegistration")
	public ModelAndView getStudentAddForm()
	{
		ModelAndView modelAndView = new ModelAndView("StudentRegistration");
		return modelAndView;

	}

	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student") Student student) {

		ModelAndView modelAndView  = new ModelAndView("RegistrationSuccess");
		studentDAO.addStudent(student);
		System.out.println("student"+student);
		return modelAndView;
	}
	
	
	@RequestMapping("/addbook") 
	public ModelAndView getAddBookForm() {
		ModelAndView modelAndView = new ModelAndView("addBook");
		return modelAndView;
	}
	
	@RequestMapping(value="/bookAddSubmit", method=RequestMethod.POST)
	public ModelAndView displayBookSubmitForm(@RequestParam("bookName") String bookName ,@RequestParam("author") String author,@RequestParam("publication") String publication,@RequestParam("description") String description,@RequestParam("availableQuantity") String availableQuantity,@RequestParam("publishDate") String publishDate,@RequestParam("availableOn") String availableOn ,@RequestParam("totalQuantity") String totalQuantity,@RequestParam("bookType") String bookType) {
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
			
		} catch (java.text.ParseException e) {
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



	@RequestMapping("/")
	public ModelAndView welcomeHome() {
		ModelAndView modelAndView = new ModelAndView("Welcome");
		return modelAndView;
	}
}
