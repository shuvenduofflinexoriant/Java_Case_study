package com.xoriant.dao;

import java.util.List;
import java.util.Map;

import com.xoriant.beans.Book;
import com.xoriant.beans.IssuedBook;
import com.xoriant.beans.Student;

public interface BookDao {
	public List<Book> getAllBooks();
	public boolean issueBookRequest(Integer userId, int bookId);
	public void returnBook(Integer issueId);
	public Map<String,IssuedBook> getAllIssuedBooks(Integer userId);
	public Map<String,IssuedBook> getAllRequestedReturnBooks(Integer userId);
}
