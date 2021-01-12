package com.xoriant.exception;

public class BookReturnDealyException extends Exception {
	public BookReturnDealyException(){
		System.out.println("Book is returned dealy, Fine needed");
	}
}
