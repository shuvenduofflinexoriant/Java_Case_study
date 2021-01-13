package com.xoriant.dao;

import com.xoriant.beans.Book;

public interface StudentDao {
	public void borrowBook(int bookId);
	public Book returnBook(int bookId);
}
