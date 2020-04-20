package com.example.ShareYourWorldWebApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.ShareYourWorldWebApp.models.Utente;

public interface UserDao extends CrudRepository<Utente, Integer> {
	List<Utente> findByNome(String name);
	List<Utente> findByCognome(String cognome);
    List<Utente> findByEmail(String email);
    List<Utente> findByUsername(String username);
    List<Utente> findByPassword(String password);
    Utente findById(int id);

}


