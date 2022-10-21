package com.plb.mediatosque.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "borrow")
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "borrowSequenceGenerator", allocationSize = 1)
	private Long id;
	
	@Column(name = "borrow_date", nullable = false)
	private LocalDate borrowDate; 
	
	@Column(name = "return_date")
	private LocalDate returnDate;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
    /*@JoinTable(name = "item_borrow",
        joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "borrow_id", referencedColumnName = "id"))*/
	@JoinColumn(name="item_id")
    private Set<Item> items = new HashSet<>();
}

