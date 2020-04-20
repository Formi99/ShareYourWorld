package com.example.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ShareYourWorldWebApp.RegistrationForm;
import com.example.models.Utente;

@Repository
public class UtentejdbcDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public List<Utente> login(String username, String password) {
        return jdbcTemplate.query(
                "select * from utenti where username = ? and password = ?",
                new Object[]{username, password},
                (rs, rowNum) ->
                        new Utente(
                                rs.getInt("Id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getString("nome"),
                                rs.getString("cognome")
                        )
        );
    }
	
<<<<<<< HEAD
	public List<Utente> Register(String username, String password, String email) {
        return jdbcTemplate.query(
                "insert into utente(Username,email,password) values (?,	?,?)",
=======
	
	public List<Utente> Register(String username, String password, String email) {
        return jdbcTemplate.query(
                "insert into utente(Username,email,password) values (?,?,?)",
>>>>>>> c43e07a396f06bb6194fdc487a91ecd24e27bff6
                new Object[]{username, password,email},
                (rs, rowNum) ->
                        new Utente(
                                rs.getInt("Id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getString("nome"),
                                rs.getString("cognome")
                        )
        );
    }
<<<<<<< HEAD
=======
	
	
	
>>>>>>> c43e07a396f06bb6194fdc487a91ecd24e27bff6
	
}
