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
	@Column(name="bookId")
	private int bookId;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publication")
	private String publication;
	
	@Column(name="description")
	private String description;
	
	@Column(name="totalQuantity")
	private int totalQuantity;
	
	@Column(name="availableQuantity")
	private int availableQuantity;
	
	@Column(name="publishDate")
	private Date publishDate;
	
	@Column(name="availableOn")
	private Date availableOn;
	
	@Column(name="bookType")
	private BookType bookType;

	public Book() {
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

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publication="
				+ publication + ", description=" + description + ", totalQuantity=" + totalQuantity
				+ ", availableQuantity=" + availableQuantity + ", publishDate=" + publishDate + ", availableOn="
				+ availableOn + ", bookType=" + bookType + "]";
	}

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

	

	
	
	

}