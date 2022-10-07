package com.plb.mediatosque.entity;

import java.time.LocalDate;

public class Livre extends Item{
	private String ISBN;

	public Livre(Long id, String title, int quantity, LocalDate releaseDate, String author, String ISBN) {
		super(id, title, quantity, releaseDate, author);
		this.ISBN = ISBN;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	
}
