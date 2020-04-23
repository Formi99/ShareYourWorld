package com.example.ShareYourWorldWebApp.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ShareYourWorldWebApp.models.CartaDiCredito;
import com.example.ShareYourWorldWebApp.models.Utente;


public interface CreditCardDao extends CrudRepository<CartaDiCredito, Integer> {
	List<CartaDiCredito> findByDatiProprietario (String datiProprietario);
	List<CartaDiCredito> findByNumero(String numero);
    List<CartaDiCredito> findByCv(int cv);
    List<CartaDiCredito> findByDataScadenza(Date dataScadenza);
    CartaDiCredito findById(int id);
    
}
