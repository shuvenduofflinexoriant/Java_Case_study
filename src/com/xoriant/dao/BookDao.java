package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Book;

public interface BookDao {
	
	
	public Book addBook();
	public List<Book> getAllBooks();

}
