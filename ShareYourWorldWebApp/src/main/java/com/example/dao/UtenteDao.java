package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.models.Utente;

public interface UtenteDao extends  CrudRepository<Utente,Integer>{
	
	 	List<Utente> findByNome(String nome);
	 	List<Utente> findByCognome(String cognome);
	    List<Utente> findByEmail(String email);
	    List<Utente> findByUsername(String username);
	    List<Utente> findByPassword(String password);
	    Utente findById(int id);

}
