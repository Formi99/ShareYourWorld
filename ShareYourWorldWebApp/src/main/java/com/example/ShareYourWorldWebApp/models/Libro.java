package com.example.ShareYourWorldWebApp.models;

import javax.persistence.Entity;

@Entity
public class Libro extends File{
	private String trama;
	private Integer pagine;
	
	public String getTrama() {
		return trama;
	}
	public void setTrama(String trama) {
		this.trama = trama;
	}
	public Integer getPagine() {
		return pagine;
	}
	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	
	
	
}
