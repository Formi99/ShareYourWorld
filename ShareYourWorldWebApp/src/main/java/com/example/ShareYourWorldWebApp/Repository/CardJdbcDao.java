package com.example.ShareYourWorldWebApp.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ShareYourWorldWebApp.CartaDiCreditoForm;
import com.example.ShareYourWorldWebApp.models.CartaDiCredito;

@Repository
public class CardJdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void CartaDiCredito(int cv, Date data_scadenza, String dati_proprietario, String numero) {
			
			jdbcTemplate.update("INSERT INTO carta_di_credito (id, cv, data_scadenza, dati_proprietario, numero) " + 
					"VALUES (NULL, ?, ?,?,?) ", cv, data_scadenza, dati_proprietario, numero );
			
			}
	
	}


