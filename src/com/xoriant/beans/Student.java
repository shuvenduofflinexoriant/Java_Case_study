package com.xoriant.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student3")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="name")
	private String name;
	private Role role;
	
	@Column(name="admissionDate")
	private Date admissionDate;
	
	@Column(name="releaseDate")
	private Date releaseDate;
	
	@Column(name="address")
	private String address;
	@Column(name="contactNumber")
	
	private String contactNumber;
	@Column(name="registrationNumber")
	private String registrationNumber;
	@Column(name="rollNumber")
	private String rollNumber;
	public Student() {
	
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
		return (Date) this.admissionDate.clone();
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = (Date) admissionDate.clone();;
	}
	public Date getReleaseDate() {
		return (Date) this.releaseDate.clone();
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = (Date) releaseDate.clone();
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
		return "Student [userId=" + userId + ", name=" + name + ", admissionDate=" + admissionDate
				+ ", releaseDate=" + releaseDate + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", registrationNumber=" + registrationNumber + ", rollNumber=" + rollNumber + "]";
	}
	
	
	
	
	
}
