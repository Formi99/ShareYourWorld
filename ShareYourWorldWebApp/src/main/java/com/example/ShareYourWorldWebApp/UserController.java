package com.example.ShareYourWorldWebApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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

import com.example.ShareYourWorldWebApp.Repository.CreditCardDao;
import com.example.ShareYourWorldWebApp.Repository.UserDao;
import com.example.ShareYourWorldWebApp.models.CartaDiCredito;
import com.example.ShareYourWorldWebApp.models.Utente;


@Controller
public class UserController {
	@Autowired
    UserDao userRepository;
	CreditCardDao cardRepository;
	
	
	@GetMapping("/LogIn")
	public String login (LogInForm logInForm) {
		return "LogIn";			
	}
	@GetMapping("/DettagliUtente")
	public ModelAndView dettUtente(HttpSession session) {
		Utente a = (Utente) session.getAttribute("loggedUser");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DettagliUtente");
		mav.addObject("utenteLoggato", a);

		return mav;	
		
	}
	
	@GetMapping("/GestioneProfilo")
	public String gestioneprofilo (GestioneProfiloForm gestioneprofiloForm, HttpSession session) {
		Utente a = (Utente) session.getAttribute("loggedUser");	
		gestioneprofiloForm.setEmail(a.getEmail());
		gestioneprofiloForm.setUsername(a.getUsername());
		gestioneprofiloForm.setPassword(a.getPassword());
		gestioneprofiloForm.setNome(a.getNome());
		gestioneprofiloForm.setCognome(a.getCognome());
		
		return "GestioneProfilo";
	}
	@PostMapping("/GestioneProfilo")
    public String  postGestioneProf(@Valid GestioneProfiloForm gestioneprofiloForm, BindingResult result,HttpSession session, ModelAndView mav){
		Utente a = (Utente) session.getAttribute("loggedUser");	
		mav.setViewName("GestioneProfilo");
		mav.addObject("utenteLoggato", a); 
		if(result.hasErrors())
            return "GestioneProfilo";

		if (gestioneprofiloForm.getUsername().equals(a.getUsername()) && gestioneprofiloForm.getPassword().equals(a.getPassword()) && gestioneprofiloForm.getEmail().equals(a.getEmail())) {
			return "GestioneProfilo";
		}else {
			a.setUsername(gestioneprofiloForm.getUsername());
			a.setPassword(gestioneprofiloForm.getPassword());
			a.setEmail(gestioneprofiloForm.getEmail());
			a.setNome(gestioneprofiloForm.getNome());
			a.setCognome(gestioneprofiloForm.getCognome());
			userRepository.save(a);
			session.setAttribute("loggedUser", a);
			return "redirect:/DatiSalvati";
		}

	}
	@GetMapping("/HomePage_Accesso")
	public String hpaccesso() {
		return "HomePage_Accesso";
	}

	@GetMapping("/registrazione")
	public String registrazione (RegistrationForm registrationForm) {
		return "registrazione";
			
	}
	@GetMapping("/SceltaCatalogo")
	public String sceltacatalogo () {
		return "SceltaCatalogo";
			
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
	public String postLogin (@Valid LogInForm logInForm, BindingResult resLogin ,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		if(resLogin.hasErrors())
			return "LogIn";
		ArrayList <Utente> utenteFind = (ArrayList<Utente>) userRepository.findAll();
		
		for(Utente u: utenteFind) {
			if(logInForm.getUsername().equals(u.getUsername()) && logInForm.getPassword().equals(u.getPassword())) {
				session = request.getSession(true);
				session.setAttribute("loggedUser", u);

				return "redirect:/HomePage_Accesso";
			}
		}
		return "LogIn";

	}  
	@GetMapping("/AggiungiPagamento")
	public String aggiungiPagamento () {
		return "AggiungiPagamento";			
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
	@GetMapping("/DatiSalvati")
	public String datiSalvati () {
		return "DatiSalvati";			
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("loggedUser", null);

		return "redirect:/LogIn";
	}

	@GetMapping("/GestionePagamento")
	public ModelAndView gestionePagamento (HttpSession session, CartaDiCreditoForm cartaDiCreditoForm) {
		Utente a = (Utente) session.getAttribute("loggedUser");	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("GestionePagamento");
		mav.addObject("loggedUser", a);
		if (a.getCartaDiCredito()==null) {
			mav.setViewName("redirect:/AggiungiPagamento");
	
		}
			return mav;	
	}
	
	@PostMapping("/AggiungiPagamento")
	public String aggiungiPagamento (HttpSession session,CartaDiCreditoForm cartaDiCreditoForm,BindingResult result) {
		if(result.hasErrors())
			return "AggiungiPagamento";
		
		Utente a = (Utente) session.getAttribute("loggedUser");
		CartaDiCredito c = new CartaDiCredito();
		c.setDatiProprietario(cartaDiCreditoForm.getDatiProprietario());
		c.setDataScadenza(cartaDiCreditoForm.getDataScadenza());
		c.setCv(cartaDiCreditoForm.getCv());
		c.setNumero(cartaDiCreditoForm.getNumero());
		
		a.setCartaDiCredito(c);
		userRepository.save(a);
		
		return "redirect:/DatiSalvati";
		
	}
}
	
	
	
	
	


