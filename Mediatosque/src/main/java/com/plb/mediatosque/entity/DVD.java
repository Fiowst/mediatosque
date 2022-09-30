package com.plb.mediatosque.entity;

import java.time.LocalDate;

public class DVD extends Truc{
	private Double duration;
	private boolean type; //true = blueray, false = normal
	
	public DVD(Long id, String title, int quantity, LocalDate releaseDate, String author, Double duration, boolean type) {
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

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	
}
