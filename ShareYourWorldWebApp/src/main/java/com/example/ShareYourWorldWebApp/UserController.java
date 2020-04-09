package com.example.ShareYourWorldWebApp;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
	
	
	@GetMapping("/LogIn")
	public String login (LogInForm logInForm) {
		return "LogIn";
			
	}
	@GetMapping("/Registrazione")
	public String registrazione (RegistrationForm registrationForm) {
		return "Registrazione";
			
	}
	
	
	@PostMapping("/LogIn")
	public String postLogin (@Valid LogInForm logInForm, BindingResult resLogin) {
		if(resLogin.hasErrors())
			return "LogIn";
		
		return "HomePage_Accesso";
		
	}
	
	@PostMapping("/Registrazione")
	public String postRegistrazione (@Valid RegistrationForm registrationForm, BindingResult resReg) {
		if(resReg.hasErrors())
			return "Registrazione";
		
		return "HomePage_Accesso";
		
	}

}
