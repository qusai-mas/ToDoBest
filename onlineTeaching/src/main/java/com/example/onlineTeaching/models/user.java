package com.example.onlineTeaching.models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="user")
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class user implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id  ;
	@Column
	private String name;
	
	@Column
	private String email;

	@Column
	private String password;
	
	@Column
	private ArrayList<String> ToDo;
	
	public user() {}
	
	public user( String name, String email, String password) {
		
		
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void SetToDo(String str) {
		ToDo.add(str);
	}
	
	
}
