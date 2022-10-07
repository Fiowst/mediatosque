package com.plb.mediatosque.service.dto;

import java.util.ArrayList;

import com.plb.mediatosque.entity.Item;

public class UserDTO {

	private Long id;
	
	private String login;
	
	private String password;
	
	private String lastName;
	
	private String firstName;
	
	private ArrayList<Item> borrows = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public ArrayList<Item> getBorrows() {
		return borrows;
	}

	public void setBorrows(ArrayList<Item> borrows) {
		this.borrows = borrows;
	}
	
}
