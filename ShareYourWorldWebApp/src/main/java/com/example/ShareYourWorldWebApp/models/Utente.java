package com.example.ShareYourWorldWebApp.models;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "utente")
public class Utente {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	@Size(min=3, max=15, message = "Nome deve esser tra 4 e 15 caratteri")
	@NotNull(message = "Nome deve esser inserito")
	//@Column(name="Username")
	private String username;
	
	@Size(min=3, max=15, message = "Nome deve esser tra 4 e 15 caratteri")
	@NotNull(message = "Nome deve esser inserito")
    //@Column(name="Nome")
	private String nome;
	
	@Size(min=3, max=15, message = "Cognome deve esser tra 4 e 15 caratteri")
	@NotNull(message = "Cognome deve esser inserito")
    //@Column(name="Cognome")
	private String cognome;
	
	@Size(min=3, max=15, message = "Password deve esser tra 4 e 40 caratteri")
	@NotNull(message = "Password deve esser inserito")
    //@Column(name="Password")
	private String password;
	
	@Size(min=8, max=50, message = "Email deve esser tra 4 e 30 caratteri")
	@NotNull(message = "Email deve esser inserito")
    //@Column(name="Email")
	private String email;

	@Transient
	private String confPassword;
	

	@OneToOne (cascade = CascadeType.ALL)
	private CartaDiCredito cartaDiCredito;
	





	public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}


	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}


	public Utente() {
		
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	/*public CartaDiCredito getCartaDiCredito() {
		return cartaDiCredito;
	}

	public void setCartaDiCredito(CartaDiCredito cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}
	
	*/

}
