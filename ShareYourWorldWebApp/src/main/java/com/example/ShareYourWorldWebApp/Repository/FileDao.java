package com.example.ShareYourWorldWebApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ShareYourWorldWebApp.models.File;
import com.example.ShareYourWorldWebApp.models.Utente;

public interface FileDao extends CrudRepository<File,Integer>{
	List<File> findByNome(String name);
	List<File> findByGenere(String Genere);
	List<File> findByAnno(int anno);
	List<File> findByPrezzo(double prezzo);
	List<File> findByPaese(String paese);
	File findById(int id);
	

}
