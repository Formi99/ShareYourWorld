package com.example.ShareYourWorldWebApp.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@Entity
@Table(name = "carta_di_credito")
public class CartaDiCredito {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	@Size (min=5, max=50)
	private String datiProprietario;
	@Size (min=13, max=16)
	private String numero;
	@Min(1)
	@Max(5)
	private int cv;
	private Date dataScadenza;
	
	public String getDatiProprietario() {
		return datiProprietario;
	}

	public void setDatiProprietario(String datiProprietario) {
		this.datiProprietario = datiProprietario;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	

}
