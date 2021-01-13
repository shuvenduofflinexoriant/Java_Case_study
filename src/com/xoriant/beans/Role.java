package com.xoriant.beans;

public enum Role {
	ADMIN(10), STUDENT(3),LIBERIAN(5),EXSTUDENT(0),NEWSTUDENT(0);
	private final int maxBookBorrow;
	
	
	Role(int maxBookBorrow){
		this.maxBookBorrow = maxBookBorrow;
	}


	public int getMaxBookBorrow() {
		return maxBookBorrow;
	}
}
