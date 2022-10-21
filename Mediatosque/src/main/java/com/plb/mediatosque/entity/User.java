package com.plb.mediatosque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userSequenceGenerator")
    //@SequenceGenerator(name = "userSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@OneToMany(mappedBy ="user")
	private Set<Borrow> borrow = new HashSet <>();

	public User(Long id, String login, String password, String lastName, String firstName) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
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
}
