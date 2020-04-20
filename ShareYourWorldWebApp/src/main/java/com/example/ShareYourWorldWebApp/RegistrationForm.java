package com.example.ShareYourWorldWebApp;

import javax.validation.constraints.Size;

public class RegistrationForm {
	
	
	@Size(min=3, max=20)
	String nome;	
	@Size(min=3, max=20)
	String cognome;
	@Size(min=3, max=20)
	String username;
	@Size(min=3, max=20)
	String password;
	@Size(min=3, max=20)
	String confPassword;
	@Size(min=7, max=50)
	String email;
	
	

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

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getconfPassword() {
		return confPassword;
	}
	public void setconfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
