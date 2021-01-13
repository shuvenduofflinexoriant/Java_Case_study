package com.xoriant.beans;

public enum BookType {
	REFERENCEBOOK(7,5), STORYBOOK(15,3), MAGAZINE(15,4);
	
	private final int maxBorrowDays;
	private final double finePerDay;
	
	BookType(int maxBorrowDays,double finePerDay){
		this.maxBorrowDays = maxBorrowDays;
		this.finePerDay = finePerDay;
	}

	public int getMaxBorrowDays() {
		return maxBorrowDays;
	}

	public double getFinePerDay() {
		return finePerDay;
	}
}
