package com.plb.mediatosque.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "itemSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	@Column(name = "author", nullable = false)
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
