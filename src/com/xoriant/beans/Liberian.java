package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Liberians")
public class Liberian {
	
	@Id
	@GenericGenerator(name = "sequence_liberian_id", strategy = "com.xoriant.generators.LiberianIdGenerator")
	@GeneratedValue(generator = "sequence_liberian_id")
	@Column(name="userid")
	private String userId;
	private String name;
	private Role role;
	public Liberian(String name) {
		super();
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
	public Liberian() {
		super();
	}
	
	
	
	
	
}
