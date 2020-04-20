package com.example.ShareYourWorldWebApp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ShareYourWorldWebApp.models.Utente;




public interface UserDao extends CrudRepository<Utente, Integer> {

}


