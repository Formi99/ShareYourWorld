package com.example.ShareYourWorldWebApp;

import javax.validation.constraints.Size;

public class GestioneProfiloForm {
	@Size(min=3, max=20)
	private String nome;
	@Size(min=3, max=20)
	private String cognome;	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Size(min=3, max=20)
	private String username;
	
	@Size(min=7, max=50)
	private String email;
	
	@Size(min=3, max=20)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
