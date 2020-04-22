package com.example.ShareYourWorldWebApp.models;

import javax.persistence.Entity;

@Entity
public class Musica extends File{
	private Integer durata;

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	
	
}
