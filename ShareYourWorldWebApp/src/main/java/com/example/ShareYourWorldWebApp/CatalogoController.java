package com.example.ShareYourWorldWebApp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShareYourWorldWebApp.*;

@RestController
public class CatalogoController {
	ArrayList<AnimeManga> listaAnimeManga=new ArrayList();
	
	public CatalogoController() {
		AnimeManga a1=new AnimeManga();
		a1.setTitolo("Naruto 1° serie");
		a1.setAnno(2002);
		a1.setEpisodi(220);
		a1.setPaese("Giappone");
		a1.setGenere("Avventura, Azione, Fantasy, Bildungsroman");
		
		AnimeManga a2=new AnimeManga();
		a2.setTitolo("Naruto Shippuden");
		a2.setAnno(2007);
		a2.setEpisodi(500);
		a2.setPaese("Giappone");
		a2.setGenere("Shonen, Azione, Avventura");
		
		AnimeManga a3=new AnimeManga();
		a3.setTitolo("Naruto next generations:Boruto");
		a3.setAnno(2016);
		a3.setEpisodi(151);
		a3.setPaese("Giappone");
		a3.setGenere("Fantasy, Azione, Avventura");
		
		listaAnimeManga.add(a1);
		listaAnimeManga.add(a2);
		listaAnimeManga.add(a3);
	}
	
	@GetMapping("/allbook")
	public ArrayList<AnimeManga> getAllUsers() {
		return listaAnimeManga;
	}
	
	@GetMapping("/bookbytitolo")
	public AnimeManga getUserByCF(@RequestParam("titolo") String titolo) {
		for(AnimeManga l:listaAnimeManga) {
			if(titolo.equals(l.getTitolo())) {
				return l;
			}
		}
		
		return null;
	}
}
