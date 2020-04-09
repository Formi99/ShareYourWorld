package com.example.ShareYourWorldWebApp;

import javax.validation.constraints.Size;

public class RegistrationForm {
	@Size(min=3, max=10)
	String username;
	@Size(min=3, max=20)
	String password;
	@Size(min=3, max=20)
	String confPassword;
	@Size(min=7, max=25)
	String email;
	
	
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
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
