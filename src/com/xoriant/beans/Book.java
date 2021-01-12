package com.xoriant.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="bookid")
	private int bookId;
	
	
	private String bookName;
	private String author;
	private String publication;
	private String description;
	private int totalQuantity;
	private int availableQuantity;
	private Date publishDate;
	private Date availableOn;
	private BookType bookType;
	
	public Book(String bookName, String author, String publication, String description, int totalQuantity,
			int availableQuantity, Date publishDate, Date availableOn, BookType bookType) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.description = description;
		this.totalQuantity = totalQuantity;
		this.availableQuantity = availableQuantity;
		this.publishDate = publishDate;
		this.availableOn = availableOn;
		this.bookType = bookType;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getAvailableOn() {
		return availableOn;
	}

	public void setAvailableOn(Date availableOn) {
		this.availableOn = availableOn;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Book() {
		super();
	}
	
	
	

}
