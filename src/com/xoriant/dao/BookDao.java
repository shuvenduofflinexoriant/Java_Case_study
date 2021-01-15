package com.xoriant.dao;

import java.util.List;
import java.util.Map;

import com.xoriant.beans.Book;
import com.xoriant.beans.IssuedBook;

public interface BookDao {
	
	
	public Book addBook(Book book);
	public List<Book> getAllBooks();
	public boolean issueBookRequest(String userId, int bookId);
	public void returnBook(Integer issueId);
	public Map<String,IssuedBook> getAllIssuedBooks(String userId);
	public Map<String,IssuedBook> getAllRequestedReturnBooks(String userId);
	public List<Book> getBookByKeyword(String keyword);
}

