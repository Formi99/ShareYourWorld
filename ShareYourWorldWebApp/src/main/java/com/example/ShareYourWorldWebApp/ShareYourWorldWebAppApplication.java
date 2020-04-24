package com.example.ShareYourWorldWebApp;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ShareYourWorldWebApp.Repository.CreditCardDao;
import com.example.ShareYourWorldWebApp.Repository.UserDao;
import com.example.ShareYourWorldWebApp.models.CartaDiCredito;
import com.example.ShareYourWorldWebApp.models.Utente;

@SpringBootApplication
public class ShareYourWorldWebAppApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShareYourWorldWebAppApplication.class, args);
	}

	@Autowired
	CreditCardDao ccd;

	@Autowired
	UserDao ud;

	@Override
	public void run(String... args) throws Exception {
		CartaDiCredito cdc = new CartaDiCredito();
		cdc.setCv(2);
		cdc.setDatiProprietario("SonoFattiMiei");
		cdc.setNumero("12345678912345");
		cdc.setDataScadenza(new Date(2020,10,10));

		
		ccd.save(cdc);

		
		Utente u = new Utente();
		u.setCognome("Lezzi");
		u.setNome("Antonio");
		u.setEmail("prova@email.it");
		u.setUsername("agente");
		u.setPassword("segreto");
		u.setConfPassword("segreto");
		u.setCartaDiCredito(cdc);

		
		ud.save(u);

		
	}

}

