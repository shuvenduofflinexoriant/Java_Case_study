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

import com.xoriant.beans.Admin;
import com.xoriant.beans.Book;
import com.xoriant.beans.BookType;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Liberian;
import com.xoriant.beans.Role;
import com.xoriant.beans.Student;
import com.xoriant.client.Client;
import com.xoriant.dao.AdminDAO;
import com.xoriant.dao.AdminDAOImpl;
import com.xoriant.dao.BookDao;
import com.xoriant.dao.BookDaoImpl;
import com.xoriant.dao.LiberianDAO;
import com.xoriant.dao.LiberianDAOImpl;
import com.xoriant.dao.LoginDAO;
import com.xoriant.dao.LoginDAOImpl;
import com.xoriant.dao.StudentDao;
import com.xoriant.dao.StudentDaoImpl;
import com.xoriant.exception.BookReturnDealyException;



@Controller
public class MyController {

	private Liberian liberian;
	private LiberianDAO liberianDAO;
	private StudentDao studentDAO;
	private BookDao bookDAO;
	private Student loggedStudent;
	private LoginDAO loginDAO;
	private AdminDAO adminDAO;
	private Admin admin;

	public MyController() {
		liberianDAO = new LiberianDAOImpl();
		studentDAO = new StudentDaoImpl();
		bookDAO = new BookDaoImpl();
		loginDAO = new LoginDAOImpl();
		adminDAO = new AdminDAOImpl();

	}

	
	@RequestMapping(value="approveStudentRegistration/{userId}")
	public ModelAndView statusChange(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("studentdata");
		modelAndView.addObject("userId",userId);
		return modelAndView;
		
	}
	
	@RequestMapping(value="studentDataAdd/{userId}" ,method=RequestMethod.POST)
	public ModelAndView statusChange1(@PathVariable("userId") String userId,@RequestParam("rollno") String rollno,@RequestParam("registration") String registration) {
		
		liberianDAO.getStudentById(userId, rollno, registration);
		ModelAndView modelAndView = new ModelAndView("bookSuccess");
		return modelAndView;
		
	}


	
	@RequestMapping("/approveReturn/{issuedId}")
	public ModelAndView approveReturnRequest(@PathVariable("issuedId") int issuedId) {

		ModelAndView modelAndView = new ModelAndView("ApproveBookReturn");
		try {
			if(liberian!=null)
				liberianDAO.approveBookReturn(issuedId, liberian);
			else {
				modelAndView = new ModelAndView("Login");
				modelAndView.addObject("error","Login To Continue!");
			}
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

		if(liberian!=null) {
			IssuedBook issuedBook = liberianDAO.collectFine(issuedId,liberian);
			modelAndView.addObject("fine",issuedBook.getFine());
			modelAndView.addObject("approver",issuedBook.getApproverId());
			modelAndView.addObject("bookname",issuedBook.getBook().getBookName());
			modelAndView.addObject("userid",issuedBook.getStudent().getUserId());
			modelAndView.addObject("username",issuedBook.getStudent().getName());
		}
		else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject("error","Login To Continue!");
		}

		return modelAndView;

	}


	

	@RequestMapping("/viewreturnrequests")
	public ModelAndView viewReturnRequests() {
		ModelAndView modelAndView = new ModelAndView("ViewReturnRequests");

		if(liberian!=null) {

			List<IssuedBook> issuedBooks = liberianDAO.getAllBookReturnRequests();
			modelAndView.addObject("issuedBooks",issuedBooks);
		}

		else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject("error","Login To Continue!");
		}


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
	public ModelAndView submitStudentRegistration(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("contactNumber") String contactNumber,
			//			@RequestParam("registrationNumber") String registrationNumber,
			//			@RequestParam("rollNumber") String rollNumber,
			@RequestParam("admissionDate") String admissionDate, 
			@RequestParam("releaseDate") String releaseDate,
			@RequestParam("password") String password) {

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
		studentDAO.addStudent(student,password);
		return modelAndView;
	}


	@RequestMapping("/addbook") 
	public ModelAndView getAddBookForm() {
		
		ModelAndView modelAndView = null;
		if(liberian!=null) {
			modelAndView = new ModelAndView("addBook");
		}else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject("error","Login To Continue!");
		}
		return modelAndView;
	}

	@RequestMapping(value="/bookAddSubmit", method=RequestMethod.POST)
	public ModelAndView displayBookSubmitForm(@RequestParam("bookName") String bookName ,
			@RequestParam("author") String author,
			@RequestParam("publication") String publication,
			@RequestParam("description") String description,
			@RequestParam("publishDate") String publishDate,
			@RequestParam("availableOn") String availableOn,
			@RequestParam("totalQuantity") String totalQuantity,
			@RequestParam("bookType") String bookType) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Book book = new Book();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setPublication(publication);
		book.setDescription(description);
		book.setTotalQuantity(Integer.parseInt(totalQuantity));
		book.setAvailableQuantity(book.getTotalQuantity());
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

	//Anjali
	@RequestMapping("/borrow")
	public ModelAndView borrowBook() {
		ModelAndView modelAndView = new ModelAndView("BorrowBook");
		List<Book> books = bookDAO.getAllBooks();
		modelAndView.addObject("books",books);
		return modelAndView;
	}

	//Anjali
	@RequestMapping(value="/SearchBook")
	public ModelAndView getBook()
	{
		ModelAndView modelAndView = new ModelAndView("SearchBook");
		modelAndView.addObject("books",bookDAO.getBookByKeyword(""));
		return modelAndView;
	}



	//sanket 

	@RequestMapping("/borrow/{bookId}")
	public ModelAndView addToIssuedBook(@PathVariable("bookId") int bookId) {
		ModelAndView modelAndView;
		System.out.println("Borrow Book  "+ bookId);

		if(bookDAO.issueBookRequest(loggedStudent.getUserId(), bookId)) {
			modelAndView = new ModelAndView("BookIssueSuccess");
		}
		else {
			modelAndView = new ModelAndView("BookIssueFail");
		}
		return modelAndView;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView displayBookSubmitForm() {

		ModelAndView modelAndView = new ModelAndView("Login");	
		if (loggedStudent!=null) {
			modelAndView = new ModelAndView("StudentProfile");
			modelAndView.addObject("id",loggedStudent.getUserId());
			modelAndView.addObject("alert",bookDAO.getBookReturnAlert(loggedStudent.getUserId()));
			modelAndView.addObject("name",loggedStudent.getName());
			modelAndView.addObject("regno",loggedStudent.getRegistrationNumber());
			modelAndView.addObject("rollno",loggedStudent.getRollNumber());
			modelAndView.addObject("address",loggedStudent.getAddress());
			modelAndView.addObject("admission",loggedStudent.getAdmissionDate());
		}else if(liberian!=null) {
			modelAndView = new ModelAndView("LiberianProfile");
			modelAndView.addObject("id",liberian.getUserId());
			modelAndView.addObject("name",liberian.getName());
			modelAndView.addObject("time",new Date().toLocaleString());
		}else if(admin != null) {
			modelAndView = new ModelAndView("AdminProfile");
			modelAndView.addObject("id","ADMIN");
			modelAndView.addObject("name",admin.getName());
			modelAndView.addObject("time",new Date().toLocaleString());
		}
		return modelAndView;

	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView displayBookSubmitForm(@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		ModelAndView modelAndView;

		if(loginDAO.login(userId, password)) {
			if (userId.startsWith("ST")) {
				loggedStudent = studentDAO.getStudentById(userId);
				modelAndView = new ModelAndView("StudentProfile");
				modelAndView.addObject("alert",bookDAO.getBookReturnAlert(loggedStudent.getUserId()));
				modelAndView.addObject("id",loggedStudent.getUserId());
				modelAndView.addObject("name",loggedStudent.getName());
				modelAndView.addObject("regno",loggedStudent.getRegistrationNumber());
				modelAndView.addObject("rollno",loggedStudent.getRollNumber());
				modelAndView.addObject("address",loggedStudent.getAddress());
				modelAndView.addObject("admission",loggedStudent.getAdmissionDate());
			}else if(userId.startsWith("LI")) {
				liberian = liberianDAO.getLiberianById(userId);
				modelAndView = new ModelAndView("LiberianProfile");
				modelAndView.addObject("id",liberian.getUserId());
				modelAndView.addObject("name",liberian.getName());
				modelAndView.addObject("time",new Date().toLocaleString());
			}else {
				admin = new Admin("Nisha Waikar");
				modelAndView = new ModelAndView("AdminProfile");
				modelAndView.addObject("id","ADMIN");
				modelAndView.addObject("name",admin.getName());
				modelAndView.addObject("time",new Date().toLocaleString());
			}
		}else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject("error","Invalid User Name or Password!");
		}
		return modelAndView;

	}



	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("Login");
		liberian = null;
		loggedStudent = null;
		admin = null;
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addliberian" , method= RequestMethod.GET) 
	public ModelAndView getForm1() {
		ModelAndView modelAndView = new ModelAndView("addLiberian");
		return modelAndView;
	}
	
	@RequestMapping(value="/liberianadded", method=RequestMethod.POST)
     public ModelAndView addLib(@RequestParam("liberianName") String liberianName,
    		 @RequestParam("password") String password,
    		 @RequestParam("confirmpassword") String confirmpassword
    		 ) {
		
		if(!password.equals(confirmpassword)) {
			ModelAndView modelAndView = new ModelAndView("addLiberian");
			modelAndView.addObject("error","Password dont match!");
			return modelAndView;
		}
		
		Liberian liberian = new Liberian(liberianName) ;
		String userId = adminDAO.addLiberian(liberian,password);
		ModelAndView modelAndView = new ModelAndView("bookSuccess");
		String msg = "Liberian "+ userId + " is Added !!";
		modelAndView.addObject("msg",msg);
		return modelAndView;
	}
	
	
	@RequestMapping(value="/approvestudent")
	public ModelAndView approve() {
		
		LiberianDAOImpl liberianDaoImpl = new LiberianDAOImpl();
		List<Student> studentData = liberianDaoImpl.approveStudentRegistration() ;
		ModelAndView modelAndView = new ModelAndView("approveStudent");
		modelAndView.addObject("studentData",studentData);
		return modelAndView;
		
	}
	
	
	@RequestMapping("/searchBook")
	public ModelAndView searchBook(@RequestParam String keyword) {
		ModelAndView modelAndView = new ModelAndView("SearchBook");
		modelAndView.addObject("books",bookDAO.getBookByKeyword(keyword));
		return modelAndView;
	}
	
	
	@RequestMapping("/issuedBooks")
	public ModelAndView currentIssuedBooks() {
		ModelAndView modelAndView = new ModelAndView("CurrentIssuedBooks");
		modelAndView.addObject("issuedBooks",bookDAO.getIssuedANDRequestedReturnBooks(loggedStudent.getUserId()));
		return modelAndView;
	}
	
	@RequestMapping("/borrowHistory")
	public ModelAndView StudentBookBorrowHistory() {
		ModelAndView modelAndView = new ModelAndView("StudentIssuedBookHistory");
		modelAndView.addObject("issuedBooks",bookDAO.getAllReturnedBooks(loggedStudent.getUserId()));
		return modelAndView;
	}
	
	@RequestMapping("/returnBook/{issuedId}")
	public ModelAndView returnBook(@PathVariable("issuedId") int issuedId) {
		ModelAndView modelAndView = new ModelAndView("bookSuccess");
		bookDAO.returnBook(issuedId);
		return modelAndView;
	}
	
	@RequestMapping("/")
	public ModelAndView welcomeHome() {
		ModelAndView modelAndView = new ModelAndView("Login");
		if (loggedStudent!=null) {
			modelAndView = new ModelAndView("StudentProfile");
			
//			Your have 2 Days left to return your books!
//					You will be fined after that!
					
			
			
			modelAndView.addObject("alert",bookDAO.getBookReturnAlert(loggedStudent.getUserId()));
			modelAndView.addObject("id",loggedStudent.getUserId());
			modelAndView.addObject("name",loggedStudent.getName());
			modelAndView.addObject("regno",loggedStudent.getRegistrationNumber());
			modelAndView.addObject("rollno",loggedStudent.getRollNumber());
			modelAndView.addObject("address",loggedStudent.getAddress());
			modelAndView.addObject("admission",loggedStudent.getAdmissionDate());
		}else if(liberian!=null) {
			modelAndView = new ModelAndView("LiberianProfile");
			modelAndView.addObject("id",liberian.getUserId());
			modelAndView.addObject("name",liberian.getName());
			modelAndView.addObject("time",new Date().toLocaleString());
		}else if(admin != null) {
			modelAndView = new ModelAndView("AdminProfile");
			modelAndView.addObject("id","ADMIN");
			modelAndView.addObject("name",admin.getName());
			modelAndView.addObject("time",new Date().toLocaleString());
		}
		return modelAndView;
	}
}

