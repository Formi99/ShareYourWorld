package com.example.ShareYourWorldWebApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	
	
	
	private Integer ID;
	
	@Size(min=3, max=15, message = "Nome deve esser tra 4 e 15 caratteri")
	@NotNull(message = "Nome deve esser inserito")
    //@Column(name="Nome")
	private String nome;
	
	public Categoria(int ID, String nome) {
		
		this.ID= ID;
		this.nome=nome;
		
		
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
