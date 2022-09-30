package com.plb.mediatosque.entity;

import java.time.LocalDate;

public class Book extends Truc{
	private String ISBN;

	public Book(Long id, String title, int quantity, LocalDate releaseDate, String author, String iSBN) {
		super(id, title, quantity, releaseDate, author);
		ISBN = iSBN;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	
}
