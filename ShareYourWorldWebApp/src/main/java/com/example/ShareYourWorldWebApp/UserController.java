package com.example.ShareYourWorldWebApp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
	public String gestioneprofilo (GestioneProfiloForm gestioneprofiloForm) {
		
		return "GestioneProfilo";
			
	}
	@PostMapping("/GestioneProfilo")
    public String postGestioneProf(@Valid GestioneProfiloForm gestioneprofiloForm, BindingResult result){
        if(result.hasErrors())
            return "GestioneProfilo";
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
	public String postLogin (@Valid LogInForm logInForm, BindingResult resLogin ,HttpSession session) {
		if(resLogin.hasErrors())
			return "LogIn";
		ArrayList <Utente> utenteFind = (ArrayList<Utente>) userRepository.findAll();
		
		for(Utente u: utenteFind) {
			if(logInForm.getUsername().equals(u.getUsername()) && logInForm.getPassword().equals(u.getPassword())) {
				session.setAttribute("Username", u.getUsername());
				session.setAttribute("email", u.getEmail());
				session.setAttribute("Password", u.getPassword());
			
				return "HomePage_Accesso";
			}
		}
		return "LogIn";

	}  
	@PostMapping("/registrazione")
    public String postRegistrazione(@Valid RegistrationForm registrationForm, BindingResult result){
        if(result.hasErrors())
            return "registrazione";

        if (registrationForm.getPassword().equals(registrationForm.getconfPassword())) {
        Utente u = new Utente();
        
        u.setNome(registrationForm.getNome());
        u.setCognome(registrationForm.getCognome());
        u.setUsername(registrationForm.getUsername());
        u.setPassword(registrationForm.getPassword());
        u.setEmail(registrationForm.getEmail());
        userRepository.save(u);
        
        }
        else {
        	return "registrazione";
        }
        return"DatiSalvati";
    }
<<<<<<< HEAD
	
	
	
	
=======

>>>>>>> 2bca96e3273fb1db2fc2167f5b475a506eb76165
}
