package com.plb.mediatosque.entity;

import java.time.LocalDate;

public class CD extends Item{
	private Double duration;
	private int nbTitle;
	
	
	public CD(Long id, String title, int quantity, LocalDate releaseDate, String author, Double duration, int nbTitle) {
		super(id, title, quantity, releaseDate, author);
		this.duration = duration;
		this.nbTitle = nbTitle;
	}


	public Double getDuration() {
		return duration;
	}


	public void setDuration(Double duration) {
		this.duration = duration;
	}


	public int getNbTitle() {
		return nbTitle;
	}


	public void setNbTitle(int nbTitle) {
		this.nbTitle = nbTitle;
	}
	
}
