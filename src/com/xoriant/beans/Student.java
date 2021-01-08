package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_data")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="roll_no")
	private Integer rollNo;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_grade")
	private Character studentGrade;

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Character getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(Character studentGrade) {
		this.studentGrade = studentGrade;
	}

	public Student() {
		
	}

	public Student(String studentName, Character studentGrade) {
		super();
		this.studentName = studentName;
		this.studentGrade = studentGrade;
	}
	
	
	

}
