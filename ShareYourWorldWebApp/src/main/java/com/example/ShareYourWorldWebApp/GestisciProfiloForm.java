package com.example.ShareYourWorldWebApp;

import javax.validation.constraints.Size;

public class GestisciProfiloForm {
	
	
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
