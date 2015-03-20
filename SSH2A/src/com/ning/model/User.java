package com.ning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author liangning
 *
 */
@Entity
@Table(name="t_user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_ID")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
