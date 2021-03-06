package com.example.ShareYourWorldWebApp;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CartaDiCreditoForm {
	
	@Size (min=5, max=50)
	@NotNull
	private String datiProprietario;
	@NotNull
	@Size (min=13, max=16)
	private String numero;
	@NotNull
	@Min(300)
	@Max(999)
	private int cv;
	@NotNull
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
