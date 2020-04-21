package com.example.ShareYourWorldWebApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="file")
public abstract class File {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	private String nome;
	private String genere;
	private Integer AnnoDiUscita;
	private double prezzo;
	private String PaeseProvenienza;
	
	
}
