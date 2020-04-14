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
	@GetMapping("/GestioneProfilo")
	public String gestioneprofilo () {
		return "GestioneProfilo";
			
	}
	@GetMapping("/registrazione")
	public String registrazione (RegistrationForm registrationForm) {
		return "registrazione";
			
	}
	@GetMapping("/SceltaCatalogo")
	public String sceltacatalogo () {
		return "SceltaCatalogo";
			
	}
	@GetMapping("/BarraRicerca")
	public String barraricerca () {
		return "BarraRicerca";
			
	}
	
	
	@PostMapping("/LogIn")
	public String postLogin (@Valid LogInForm logInForm, BindingResult resLogin) {
		if(resLogin.hasErrors())
			return "LogIn";
		
		return "HomePage_Accesso";
		
	}
	
	@PostMapping("/registrazione")
	public String postRegistrazione (@Valid RegistrationForm registrationForm, BindingResult resReg) {
		if(resReg.hasErrors())
			return "registrazione";
		
		return "HomePage_Accesso";
		
	}

}
