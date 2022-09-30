package com.plb.mediatosque.entity;

import java.util.ArrayList;

public class User {
	private Long id;
	private String login;
	private String password;
	private String lastName;
	private String firstName;
	private ArrayList<Truc> borrows = new ArrayList<>();

	public User(Long id, String login, String password, String lastName, String firstName) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.borrows = null;
	}
	
	//emprunter un truc
	
	//rendre un truc
	
	//consulter la liste
	
	
	//getter and setter
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

	public ArrayList<Truc> getBorrows() {
		return borrows;
	}

	public void setBorrows(ArrayList<Truc> borrows) {
		this.borrows = borrows;
	}
	

	
}
