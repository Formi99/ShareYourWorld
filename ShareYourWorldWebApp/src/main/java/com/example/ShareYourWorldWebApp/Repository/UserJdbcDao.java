package com.example.ShareYourWorldWebApp.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDao {

    private JdbcTemplate jdbcTemplate;
	
	public void Utente(Integer id_carta,Integer Id ) {
			jdbcTemplate.update("UPDATE utente " + 
					"SET ID_carta_credito = ? " + 
					"WHERE utente.ID = ? " , id_carta, Id);
	}

}
