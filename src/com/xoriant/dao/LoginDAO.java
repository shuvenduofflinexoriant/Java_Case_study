package com.xoriant.dao;

public interface LoginDAO {
	public boolean register(String userId, String password);
	public boolean login(String userId, String password);
	public boolean changePassword(String userId, String password,String newPassword);
}
