package com.xoriant.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="issuedbook")
public class IssuedBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int issueId;
	
	@Column(name="bookid")
	private int bookId;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid",foreignKey=@ForeignKey(name="userid"))
	private Student student;
	
	@Column(name="issuedate")
	private Date issueDate;
	
	@Column(name="returningdate")
	private Date returningDate;
	
	@Column(name="returneddate")
	private Date returnedDate;
	
	@Column(name="approverid")
	private String approverId;
	
	@Column(name="fine")
	private double fine;
	
	public IssuedBook(int bookId, Student student, Date issueDate, Date returningDate) {
		super();
		this.bookId = bookId;
		this.student = student;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
		this.returnedDate = null;
		this.approverId = null;
		this.fine = 0;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(Date returningDate) {
		this.returningDate = returningDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public IssuedBook() {
		super();
	}

	@Override
	public String toString() {
		return "IssuedBook [bookId=" + bookId + ", userId=" + student + ", issueDate=" + issueDate + ", returningDate="
				+ returningDate + ", returnedDate=" + returnedDate + ", approverId=" + approverId + ", fine=" + fine
				+ "]";
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	
	
	
	

}
