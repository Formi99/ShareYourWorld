/* package com.example.ShareYourWorldWebApp;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ShareYourWorldWebApp.Repository.CategoriaDao;
import com.example.ShareYourWorldWebApp.Repository.FileDao;
import com.example.ShareYourWorldWebApp.Repository.UserDao;
import com.example.ShareYourWorldWebApp.models.Categoria;
import com.example.ShareYourWorldWebApp.models.File;
import com.example.ShareYourWorldWebApp.models.Utente;

@Controller
public class UserControllerFile {
	
	@Autowired
	//FileDao fileDao;
	UserDao userRepository;
	CategoriaDao categoriaDao;
	
	
	@GetMapping("/BarraRicerca")
	public String barraricerca (HttpSession session) {
		
		Utente u= (Utente) session.getAttribute("loggedUser");
		
		Categoria manga= new Categoria(1,"Manga");
		Categoria musica = new Categoria(2,"Musica");
		Categoria eBook = new Categoria(2,"");
		Categoria Manga= (Categoria) categoriaDao.findByID(1);
		Categoria ebook= (Categoria) categoriaDao.findByID(2);
		Categoria musica= (Categoria) categoriaDao.findByID(3);
		
		ArrayList<File> lista_file = new ArrayList <File>();
		
		lista_file= (ArrayList<File>) fileDao.findAll();
		
		for(File a: lista_file) {
			
				
			
			
		}
		
	
		return "BarraRicerca";
			
	}
	
	
	
	
	
	
	


}
*/