package com.example.ShareYourWorldWebApp;

import javax.validation.constraints.Size;

public class LogInForm {
	@Size(min=3, max=20)
	String username;
	@Size(min=3, max=25)
	String password;
	
	
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

}

