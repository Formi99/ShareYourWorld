package com.example.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.models.Utente;



public interface UserDao extends CrudRepository<Utente, Integer> {

}


