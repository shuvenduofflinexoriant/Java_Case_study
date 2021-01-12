package com.xoriant.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GenericGenerator(name = "sequence_emp_id", strategy = "com.xoriant.beans.EmployeeIdGenerator")
	@GeneratedValue(generator = "sequence_emp_id")
	@Column(name="userid")
	private String userId;
	
	private String name;
	private Role role;
	private Date admissionDate;
	private Date releaseDate;
	private String address;
	private String contactNumber;
	
	
	private String registrationNumber;
	private String rollNumber;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	@Override
	public String toString() {
		return "Student [userId=" + userId + ", name=" + name + ", role=" + role + ", admissionDate=" + admissionDate
				+ ", releaseDate=" + releaseDate + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", registrationNumber=" + registrationNumber + ", rollNumber=" + rollNumber + "]";
	}
	public Student(String name, Date admissionDate, Date releaseDate, String address, String contactNumber,
			String registrationNumber, String rollNumber) {
		super();
		this.name = name;
		this.role = Role.NEWSTUDENT;
		this.admissionDate = admissionDate;
		this.releaseDate = releaseDate;
		this.address = address;
		this.contactNumber = contactNumber;
		this.registrationNumber = registrationNumber;
		this.rollNumber = rollNumber;
	}
	public Student() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
