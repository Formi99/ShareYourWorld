package com.example.ShareYourWorldWebApp;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ShareYourWorldWebApp.Repository.UserDao;
import com.example.ShareYourWorldWebApp.models.Utente;




@Controller
public class UserController {
	@Autowired
    UserDao userRepository;


	
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
	@GetMapping("/GestisciAbbonamento")
	public String gestabb () {
		return "GestisciAbbonamento";
			
	}
	@GetMapping("/CambiaPassword")
	public String changepsw () {
		return "CambiaPassword";
			
	}
	
	
	
	@PostMapping("/LogIn")
	public String postLogin (@Valid LogInForm logInForm, BindingResult resLogin) {
		if(resLogin.hasErrors())
			return "LogIn";
		ArrayList <Utente> utenteFind = (ArrayList<Utente>) userRepository.findAll();
		
		for(Utente u: utenteFind) {
			if(logInForm.getUsername().equals(u.getUsername()) && logInForm.getPassword().equals(u.getPassword())) {	
				return "HomePage_Accesso";
			}
		}
		return "LogIn";
		
		
	}  
	
	  @PostMapping("/registrazione")
	    public String postRegistrazione(@Valid RegistrationForm registrationForm, BindingResult result){
	        if(result.hasErrors())
	            return "registrazione";

	        Utente u = new Utente();
	        if(!u.getConfPassword().equals(registrationForm.getEmail())) {
	        	return "registrazione";
	        }
	        u.setNome(registrationForm.getNome());
	        u.setCognome(registrationForm.getCognome());
	        u.setUsername(registrationForm.getUsername());
	        u.setPassword(registrationForm.getPassword());
	        u.setEmail(registrationForm.getEmail());
	        userRepository.save(u);
	        return"DatiSalvati";
	    }

}
