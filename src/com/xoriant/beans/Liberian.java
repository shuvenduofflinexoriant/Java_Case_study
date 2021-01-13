package com.xoriant.beans;

public class Liberian {
	private String userId;
	private String name;
	private Role role;
	
	public Liberian(String name) {

		this.name = name;
		this.role = Role.LIBERIAN;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
