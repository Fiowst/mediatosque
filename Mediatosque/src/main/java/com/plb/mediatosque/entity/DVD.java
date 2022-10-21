package com.plb.mediatosque.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class DVD extends Item{
	private Double duration;
	
	@Enumerated(EnumType.STRING)
	private DVDType type;
	
	public DVD() {}

	public DVD(Long id, String title, int quantity, LocalDate releaseDate, String author, Double duration, DVDType type) {
		super(id, title, quantity, releaseDate, author);
		this.duration = duration;
		this.type = type;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public DVDType getType() {
		return type;
	}

	public void setType(DVDType type) {
		this.type = type;
	}
	
}
