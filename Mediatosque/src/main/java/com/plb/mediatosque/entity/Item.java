package com.plb.mediatosque.entity;

import java.time.LocalDate;

public class Item {
	private Long id;
	private String title;
	private int quantity;
	private LocalDate releaseDate;
	private String author;
	
	public Item(Long id, String title, int quantity, LocalDate releaseDate, String author) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.releaseDate = releaseDate;
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
