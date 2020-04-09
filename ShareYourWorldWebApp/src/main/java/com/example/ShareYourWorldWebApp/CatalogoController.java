package com.example.ShareYourWorldWebApp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShareYourWorldWebApp.*;

@RestController
public class CatalogoController {
	ArrayList<Libro> listaLibri=new ArrayList();
	
	public CatalogoController() {
		Libro l1=new Libro();
		l1.setTitolo("Naruto 1° serie");
		l1.setAnno(2002);
		l1.setEpisodi(220);
		l1.setPaese("Giappone");
		l1.setGenere("Avventura, Azione, Fantasy, Bildungsroman");
		
		Libro l2=new Libro();
		l2.setTitolo("Naruto Shippuden");
		l2.setAnno(2007);
		l2.setEpisodi(500);
		l2.setPaese("Giappone");
		l2.setGenere("Shonen, Azione, Avventura");
		
		Libro l3=new Libro();
		l3.setTitolo("Naruto next generations:Boruto");
		l3.setAnno(2016);
		l3.setEpisodi(151);
		l3.setPaese("Giappone");
		l3.setGenere("Fantasy, Azione, Avventura");
		
		listaLibri.add(l1);
		listaLibri.add(l2);
		listaLibri.add(l3);
	}
	
	@GetMapping("/allbook")
	public ArrayList<Libro> getAllUsers() {
		return listaLibri;
	}
	
	@GetMapping("/bookbytitolo")
	public Libro getUserByCF(@RequestParam("titolo") String titolo) {
		for(Libro l:listaLibri) {
			if(titolo.equals(l.getTitolo())) {
				return l;
			}
		}
		
		return null;
	}
}
