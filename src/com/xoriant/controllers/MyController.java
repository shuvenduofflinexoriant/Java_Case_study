package com.xoriant.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Liberian;
import com.xoriant.beans.Student;
import com.xoriant.client.Client;
import com.xoriant.dao.LiberianDAO;
import com.xoriant.dao.LiberianDAOImpl;
import com.xoriant.exception.BookReturnDealyException;



@Controller
public class MyController {
	
	private Liberian liberian;
	private LiberianDAO liberianDAO;
	
	public MyController() {
		 liberianDAO = new LiberianDAOImpl();
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
	public ModelAndView sayHello(@PathVariable("issuedId") int issuedId) {
		ModelAndView modelAndView = new ModelAndView("ApproveBookReturn");
//		try {
//			liberianDAO.approveBookReturn(issuedId, liberian);
//		} catch (BookReturnDealyException e) {
//			//Display Fine 
//			
//		}
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
	public ModelAndView getStudent()
	{
		ModelAndView modelAndView = new ModelAndView("StudentRegistration");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student") Student student) {
	
		ModelAndView modelAndView  = new ModelAndView("RegistrationSuccess");
		//TODO ADD STUDENT
		System.out.println("student"+student);
		return modelAndView;
	}
	
	
	
	@RequestMapping("/")
	public ModelAndView welcomeHome() {
		ModelAndView modelAndView = new ModelAndView("Welcome");
		return modelAndView;
	}
}
